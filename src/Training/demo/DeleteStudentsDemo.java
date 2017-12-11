package Training.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Training.Course;
import Training.Instructor;
import Training.InstructorDetail;
import Training.Review;
import Training.Student;

public class DeleteStudentsDemo {

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
			int theId = 1;
			Student tempStudent = session.get(Student.class, theId);
			
			System.out.println("Deleting student: " + tempStudent);
			session.delete(tempStudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("M�J KOD ---- Done!");
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
