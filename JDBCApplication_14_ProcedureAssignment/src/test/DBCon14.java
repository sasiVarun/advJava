package test;
import java.util.Scanner;
import java.sql.*;
public class DBCon14 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			System.out.println("Enter Employee Id:");
			String eId = sc.nextLine();
			
			CallableStatement cs = con.prepareCall("{call RetrieveEmployeeDetails38(?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, eId);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.INTEGER);
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.registerOutParameter(9, Types.BIGINT);
			cs.registerOutParameter(10, Types.FLOAT);
			cs.registerOutParameter(11, Types.FLOAT);
			
			cs.execute();//Executing Procedure
			
			System.out.println("Employee ID: "+eId);
			System.out.println("Employee Name: "+cs.getString(2));
			System.out.println("Designation: "+cs.getString(3));
			System.out.println("House No: "+cs.getString(4));
			System.out.println("Street Name: "+cs.getString(5));
			System.out.println("City Name: "+cs.getString(6));
			System.out.println("Pin Code: "+cs.getString(7));
			System.out.println("Mail Id: "+cs.getString(8));
			System.out.println("Phone Number: "+cs.getString(9));
			System.out.println("Basic Salary: "+cs.getString(10));
			System.out.println("Total Salary: "+cs.getString(11));
			
			System.out.println("Procedure executed Successfully...");
			sc.close();

		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
