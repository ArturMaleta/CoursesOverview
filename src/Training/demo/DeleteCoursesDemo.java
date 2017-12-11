package Training.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Training.Course;
import Training.Instructor;
import Training.InstructorDetail;
import Training.Review;
import Training.Student;

public class DeleteCoursesDemo {

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
			int theId = 10;
			int theeId = 12;
			Course tempCourse1 = session.get(Course.class, theId);
			Course tempCourse2 = session.get(Course.class, theeId);
			
			session.delete(tempCourse1);
			session.delete(tempCourse2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("MÓJ KOD ---- Done!");
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
