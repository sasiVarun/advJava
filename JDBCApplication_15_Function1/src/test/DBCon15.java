package test;
import java.util.*;
import java.sql.*;
public class DBCon15 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			System.out.println("Enter AccNo:");
			long accNo = Long.parseLong(sc.nextLine());
			CallableStatement cs = con.prepareCall("{call ? := RetrieveBalance38(?)}");
			
			cs.registerOutParameter(1, Types.FLOAT);
			cs.setLong(2, accNo);
			
			cs.execute();
			System.out.println("Account No: "+accNo);
			System.out.println("Balance: "+cs.getFloat(1));
			sc.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
