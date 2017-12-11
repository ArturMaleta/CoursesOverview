package Training.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Training.Course;
import Training.Instructor;
import Training.InstructorDetail;
import Training.Review;
import Training.Student;

public class CreateCoursesAndStudentsDemo {

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
			System.out.println("\nMÓJ KOD ---- Creating courses.");
			Course tempCourse1 = new Course("Java EE");
			Course tempCourse2 = new Course("Spring Hibernate forU!");
			Course tempCourse3 = new Course("MySQL for dummies");
			
			System.out.println("\nMÓJ KOD ---- Creating students.");
			Student tempStudent1 = new Student("Johnny B.", "Good", "johnny@gmail.com");
			Student tempStudent2 = new Student("Chuck", "Berry", "chuck@gmail.com");
			Student tempStudent3 = new Student("James", "Hetfield", "james@gmail.com");
			Student tempStudent4 = new Student("Ray", "Charles", "ray@gmail.com");
			Student tempStudent5 = new Student("Joe", "Satriani", "joe@gmail.com");
						
			System.out.println("\nMÓJ KOD ---- Adding students to courses.");
			tempCourse1.addStudent(tempStudent1);
			tempCourse1.addStudent(tempStudent2);
			tempCourse1.addStudent(tempStudent3);
			tempCourse1.addStudent(tempStudent4);
			tempCourse1.addStudent(tempStudent5);
			
			tempCourse2.addStudent(tempStudent1);
			tempCourse2.addStudent(tempStudent3);
			tempCourse2.addStudent(tempStudent5);
			
			tempCourse3.addStudent(tempStudent2);
			tempCourse3.addStudent(tempStudent4);
			
			session.save(tempCourse1);
			session.save(tempCourse2);
			session.save(tempCourse3);
			
			System.out.println("\nMÓJ KOD ---- Saving students.");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			session.save(tempStudent4);
			session.save(tempStudent5);
			System.out.println("\nMÓJ KOD ---- Saved students for Java EE: " + tempCourse1.getStudents());
			System.out.println("\nMÓJ KOD ---- Saved students for Spring Hibernate forU!: " + tempCourse2.getStudents());
			System.out.println("\nMÓJ KOD ---- Saved students for MySQL for Dummies: " + tempCourse3.getStudents() + "\n");
			
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
