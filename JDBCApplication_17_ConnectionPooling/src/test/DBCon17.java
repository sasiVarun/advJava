package test;
import java.sql.*;
public class DBCon17 {

	public static void main(String[] args) {
		try {
			Pooling p = new Pooling("jdbc:oracle:thin:@localhost:1521:xe","system","admin"); //Constructor Call
			p.createConnection();
			System.out.println("Pool Size:"+p.v.size());
			Connection con = p.takeConnection();
			System.out.println("Connection taken:"+con);
			System.out.println("Pool Size:"+p.v.size());
			PreparedStatement ps = con.prepareStatement("select * from bank38");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getLong(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3)+"\t"+rs.getString(4));
			}//end of loop
			p.returnConnection(con);
			System.out.println("Pool Size:"+p.v.size());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
