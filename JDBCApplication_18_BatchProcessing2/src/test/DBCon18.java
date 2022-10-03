package test;

import java.sql.*;

public class DBCon18 {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			PreparedStatement ps = con.prepareStatement("insert into Emp38 values(?,?,?,?)");
			ps.setString(1,"A333");
			ps.setString(2,"Bharath");
			ps.setString(3,"Manager");
			ps.setFloat(4,15000);
			ps.addBatch();
			
			ps.setString(1,"A444");
			ps.setString(2,"Mohan");
			ps.setString(3,"Analyst");
			ps.setFloat(4,7000);
			ps.addBatch();
			
			int k[] = ps.executeBatch();
			for(int i=0;i<k.length;i++) {
				System.out.println("Data inserted successfully...");
			}//end of loop
			ps.clearBatch();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
