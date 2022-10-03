package test;
import java.sql.*;
import javax.sql.*;
public class DBCon21 {
	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			DatabaseMetaData dmd = con.getMetaData();
			System.out.println("*****DatabaseMetaData*****");
			System.out.println("DriverName:"+dmd.getDriverName());
			
			PreparedStatement ps = con.prepareStatement("update product38 set pprice = ? where pcode = ?");
			ParameterMetaData pmd = ps.getParameterMetaData();
			System.out.println("Count of Parameters:"+pmd.getParameterCount());
			
			PreparedStatement ps2 = con.prepareStatement("select * from product38");
			ResultSet rs = ps2.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println("*****ResultSetMetaData*****");
			System.out.println("Column Count:"+rsmd.getColumnCount());
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
