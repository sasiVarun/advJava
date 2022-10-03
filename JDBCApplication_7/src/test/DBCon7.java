package test;

import java.sql.*;
import java.util.Scanner;
public class DBCon7 {

	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			System.out.println("Enter User-Name:");
			String uname = sc.nextLine();
			System.out.println("Enter Password:");
			String pword = sc.nextLine();
			System.out.println("Enter First Name:");
			String fName = sc.nextLine();
			System.out.println("Enter Last Name:");
			String lName = sc.nextLine();
			System.out.println("Enter Address:");
			String addr = sc.nextLine();
			System.out.println("Enter Mail-ID:");
			String mailId = sc.nextLine();
			System.out.println("Enter Phone Number:");
			long phno = sc.nextLong();
			
			PreparedStatement ps = con.prepareStatement("insert into userreg38 values(?,?,?,?,?,?,?)");
			System.out.println(ps.toString());
			ps.setString(1, uname);
			ps.setString(2, pword);
			ps.setString(3, fName);
			ps.setString(4, lName);
			ps.setString(5, addr);
			ps.setString(6, mailId);
			ps.setLong(7, phno);
			System.out.println(ps.toString());
			int k = ps.executeUpdate();
			
			if(k>0) {
				System.out.println(k+" Record/s created successfully");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
