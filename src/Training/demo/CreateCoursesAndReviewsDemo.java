package Training.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Training.Course;
import Training.Instructor;
import Training.InstructorDetail;
import Training.Review;
import Training.Student;

public class CreateCoursesAndReviewsDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();

		Session session = factory.getCurrentSession();
		
		try {
			// start transaction
			session.beginTransaction();

			// create some courses
			int theCourseFirstId = 10;
			int theCourseSecondId = 11;
			int theCourseThirdId = 12;
			Course tempCourse1 = session.get(Course.class, theCourseFirstId);
			Course tempCourse2 = session.get(Course.class, theCourseSecondId);
			Course tempCourse3 = session.get(Course.class, theCourseThirdId);

			tempCourse1.addReview(new Review("Damn, so good!"));
			tempCourse1.addReview(new Review("eeeh, crap."));
			tempCourse2.addReview(new Review("I like this course"));
			tempCourse2.addReview(new Review("nothing interesting."));
			tempCourse3.addReview(new Review("I recommend this course."));
			tempCourse3.addReview(new Review("Don't like it. Nothin new."));
			
		
			// save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);

			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}
