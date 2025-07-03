package day31;
import java.sql.*;
public class JDBCconnection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		 {
		        String url = "jdbc:mysql://localhost:3306/";
		        String user = "root";
		        String password = "root";

		        try {
		            Connection conn = DriverManager.getConnection(url, user, password);
		            Statement stmt = conn.createStatement();

		            stmt.execute("CREATE DATABASE IF NOT EXISTS employee_db");
		            System.out.println("Database 'employee_db' created or already exists.");

		            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", user, password);
		            stmt = conn.createStatement();

		            stmt.execute("CREATE TABLE IF NOT EXISTS demo_table (" +
		                         "Empcode INT, Empname VARCHAR(25), empage INT, esalary INT)");

		            System.out.println("Table 'demo_table' created or already exists.");
		            conn.close();
		        } 
		        catch (SQLException e) 
		        {
		            e.printStackTrace();
		        }
		    }

	}

}
