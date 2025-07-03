package day31;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCconnectivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		 String db_url="jdbc:mysql://localhost:3306";
		 String user = "root";
	     String password = "root";
	     
	     try {
			Connection connection = DriverManager.getConnection(db_url, user, password);
		
			String create_DB = "create database employee_Data_1";
			String useDB = "use employee_Data_1";
			String CreateTable = "Create table employee_Data_1 (Empcode int, Empname varchar(25), empage int, esalary int)";
			String insert = "insert into employee_Data_1 (Empcode,Empname,empage,esalary) values (101,'Jenny',25,10000), (102,'Jacky',30,20000),(103,'Joe',20,40000), (104,'John',40,80000), (105,'Shameer',25,90000)";
			String select = "Select * from employee_Data_1";
			 
		    Statement smt = connection.createStatement();
		    smt.execute(create_DB);
		    smt.execute(useDB);
		    smt.execute(CreateTable);
		    smt.executeUpdate(insert);
		    
		    ResultSet result = smt.executeQuery(select);
		    
		    while(result.next()) {
		    	System.out.println(result.getInt("Empcode") + "||"+ result.getString("Empname") + "||"+ result.getInt("empage") + "||"+ result.getInt("esalary"));
		    }
		    
		    connection.close();
			
			
	     } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	}

}
