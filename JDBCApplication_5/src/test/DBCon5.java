package test;

import java.util.Scanner;
import java.sql.*;
public class DBCon5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Book Code:");
		String bcode = sc.nextLine();
		System.out.println("Enter Book Name:");
		String bname = sc.nextLine();
		System.out.println("Enter Book Author:");
		String bauthor = sc.nextLine();
		System.out.println("Enter Book Price:");
		float pprice = Float.parseFloat(sc.nextLine());
		System.out.println("Enter Book Qunatity:");
		int qty = Integer.parseInt(sc.nextLine());
		
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			Statement stm = con.createStatement();
			int k = stm.executeUpdate("insert into book38 values('"+ bcode + "','" +bname  + "','" + bauthor  + "'," +pprice + "," +qty+")");
			
			if(k>0) {
				System.out.println("Record inserted successfully..");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		}

	}

}
