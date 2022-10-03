package test;

import java.sql.*;
import java.util.Scanner;
public class DBCon8 {

	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			System.out.println("Enter the Roll No:");
			String rollNo = sc.nextLine();
			
			PreparedStatement ps = con.prepareStatement("select * from student38 where rollno = ?");
			ps.setString(1, rollNo);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getString(1) + "\t"+rs.getString(2) +"\t" + rs.getString(3)+ "\t" + rs.getString(4)+ "\t"
						+ rs.getString(5)+ "\t" + rs.getLong(6)+ "\t");
			}
			else {
				System.out.println("Invalid roll number");
			}
			
			sc.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
