package Training.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Training.Course;
import Training.Instructor;
import Training.InstructorDetail;
import Training.Review;
import Training.Student;

public class CreateInstructorDemo {

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
			// create instructor object
			Instructor tempInstructor = new Instructor("Artur", "Maleta", "arturmaleta@gmail.com");
			InstructorDetail tempInstructorDetail =	new InstructorDetail("Polish", "onion fighting");
			
			Instructor tempInstructor1 = new Instructor("John", "Doe", "johndoe@gmail.com");
			InstructorDetail tempInstructorDetail1 =	new InstructorDetail("English", "fish&chips");
			
			Instructor tempInstructor2 = new Instructor("Gunnar", "Nelson", "gunnarnelson@gmail.com");
			InstructorDetail tempInstructorDetail2 =	new InstructorDetail("Icelanding", "provide fish and aluminium");
			
			// associate objects 
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			tempInstructor1.setInstructorDetail(tempInstructorDetail1);
			tempInstructor2.setInstructorDetail(tempInstructorDetail2);
			
			// start transaction
			session.beginTransaction();
			
			// save transaction
			// this will also save InstructorDetail, cause its associated with Instructor - CascadeType.all
			System.out.println("\nSaving instructor: " + tempInstructor);
			session.save(tempInstructor);
			session.save(tempInstructor1);
			session.save(tempInstructor2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
