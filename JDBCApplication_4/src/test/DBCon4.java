package test;
import java.sql.*;
public class DBCon4 {

	public static void main(String[] args) {
		
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from customer38");
			
			while(rs.next()) {
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getFloat(4)+"\t"+rs.getString(5));
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
