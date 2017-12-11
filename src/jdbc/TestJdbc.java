package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/courses-overview?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("trying to connect to database");
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Successful");
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

}
