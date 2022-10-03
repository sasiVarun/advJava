package test;

import java.sql.*;
import java.util.Scanner;
public class DBCon9 {

	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			System.out.println("Enter the User Name");
			String uName = sc.nextLine();
			System.out.println("Enter the Password");
			String pwod = sc.nextLine();
			
			PreparedStatement ps = con.prepareStatement("select * from userreg38 where uname = ? and pword = ?");
			ps.setString(1, uName);
			ps.setString(2, pwod);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getString(3) + "\t" +rs.getString(4) + "\t" +
						rs.getString(5) + "\t" +rs.getString(6) + "\t" +rs.getLong(7) + "\t");
			} else {
				System.out.println("Inavalid User-Name & Password");
			}
			sc.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
