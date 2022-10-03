package test;
import java.sql.*;
import java.util.*;
public class DBCon14 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			System.out.println("Enter the Account No:");
			long accNo = sc.nextLong();
			
			CallableStatement cs = con.prepareCall("{call CustDataRetrieve38(?,?,?,?,?,?,?)}");
			
			cs.setLong(1, accNo);
			cs.registerOutParameter(2, Types.VARCHAR);
			cs.registerOutParameter(3, Types.FLOAT);
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.registerOutParameter(5, Types.VARCHAR);
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.registerOutParameter(7, Types.BIGINT);
			
			cs.execute();//Executing procedure
			System.out.println("AccNo: "+accNo);
			System.out.println("Customer Name: "+cs.getString(2));
			System.out.println("Balance: "+ cs.getFloat(3));
			System.out.println("Account Type: "+cs.getString(4));
			System.out.println("Address: "+ cs.getString(5));
			System.out.println("Mail-Id: "+cs.getString(6));
			System.out.println("Phone Number: "+cs.getLong(7));
			
			System.out.println("Procedure executed Successfully...");
			sc.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
