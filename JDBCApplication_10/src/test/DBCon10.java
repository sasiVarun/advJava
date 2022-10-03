package test;

import java.sql.*;
import java.util.Scanner;


public class DBCon10 {

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
				System.out.println("Old Price: "+rs.getFloat(3));
				System.out.println("Enter New Product Price");
				float price = sc.nextFloat();
				
				PreparedStatement ps2 = con.prepareStatement("update product38 set pprice = ? where pcode = ?");
				ps2.setFloat(1, price);
				ps2.setString(2, pCode);
				
				int k = ps2.executeUpdate();
				
				if(k>0) {
					System.out.println("Updated rows");
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
