package test;

import java.util.Scanner;
import java.sql.*;
public class DBCon6 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			System.out.println("Enter Roll No:");
			String rNo = sc.nextLine();
			System.out.println("Enter Student Name:");
			String sName = sc.nextLine();
			System.out.println("Enter Branch:");
			String br = sc.nextLine();
			System.out.println("Enter Address:");
			String addr = sc.nextLine();
			System.out.println("Enter Mail-ID:");
			String mId = sc.nextLine();
			System.out.println("Enter Phone Number:");
			long phNo = sc.nextLong();
			
			PreparedStatement ps = con.prepareStatement("insert into student38 values(?,?,?,?,?,?)"); //Query-Structure is complied
			
			ps.setString(1, rNo);
			ps.setString(2, sName);
			ps.setString(3, br);
			ps.setString(4, addr);
			ps.setString(5, mId);
			ps.setLong(6, phNo);
			
			int k = ps.executeUpdate(); //Query executed with values.
			if(k>0) {
				System.out.println("Rows updated successfully..");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		}

	}

}
