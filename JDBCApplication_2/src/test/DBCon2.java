package test;
import java.util.Scanner;
import java.sql.*;
public class DBCon2 {

	public static void main(String[] args) {
		try {
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the EmpID:");
			String eId = sc.nextLine();
			System.out.println("Enter the Emp Name:");
			String eName = sc.nextLine();
			System.out.println("Enter the Designation:");
			String eDesg = sc.nextLine();
			System.out.println("Enter the Basic Salary:");
			int bSal = sc.nextInt();
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			Statement stm = con.createStatement();
			
			int k = stm.executeUpdate("Insert into emp38 value('"+eId+"','"+eName+"','"+eDesg+"',"+ bSal +")");
			
			if(k>0) {
				System.out.println("Employee Details inserted successfully");
			}
			sc.close();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
