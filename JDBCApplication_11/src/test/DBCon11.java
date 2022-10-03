package test;

import java.sql.*;
import java.util.Scanner;


public class DBCon11 {

	public static void main(String[] args) {
		
		try {
			Scanner sc =  new Scanner(System.in);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			System.out.println("Enter the Product code");
			String pCode = sc.nextLine();
			
			PreparedStatement ps1 = con.prepareStatement("select * from product38 where pcode = ?");
			ps1.setString(1, pCode);
			
			ResultSet rs = ps1.executeQuery();
			if(rs.next()) {
								
				PreparedStatement ps2 = con.prepareStatement("delete from product38 where pcode = ?");
				ps2.setString(1, pCode);
				
				int k = ps2.executeUpdate();
				
				if(k>0) {
					System.out.println("Product details deleted");
				}
			} else {
				System.out.println("Invalid Product code...");
			}
			
			sc.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
