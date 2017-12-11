package Training.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Training.Course;
import Training.Instructor;
import Training.InstructorDetail;
import Training.Review;
import Training.Student;

public class DeleteCoursesOrStudentsDemo {

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
					
			System.out.println("\nMÓJ KOD ---- Deleting students.");
			for (int i = 6; i <= 10; i++) {
				Student tempStudent = session.get(Student.class, i);
				session.delete(tempStudent);
			}
						
			
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
