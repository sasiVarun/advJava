package test;
import java.util.Scanner;
import java.sql.*;
public class DBCon13 {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			Scanner sc = new Scanner(System.in);
			Student st = new Student();
			Read r = new Read();
			r.read(sc, st);
			
			PreparedStatement ps = con.prepareStatement("{call StudentRecords38(?,?,?,?,?,?,?,?,?,?,?,?)}");
			
			ps.setString(1, st.rollNo);
			ps.setString(2, st.name);
			ps.setString(3, st.branch);
			ps.setString(4, st.ad.hNo);
			ps.setString(5, st.ad.sName);
			ps.setString(6, st.ad.city);
			ps.setInt(7, st.ad.pinCode);
			ps.setString(8, st.mailId);
			ps.setLong(9, st.phNo);
			ps.setFloat(10, st.sr.totalMarks);
			ps.setFloat(11, st.sr.per);
			ps.setString(12, st.sr.result);
			
			ps.execute(); //Procedure Execution
			System.out.println("Procedure Executed Successfully...");
			
			sc.close();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
