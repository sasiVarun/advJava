package test;
import java.sql.*;
import java.util.*;
public class DBCon12 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			System.out.println("Enter AccNo:");
			long accNo = Long.parseLong(sc.nextLine());
			System.out.println("Enter the CustName:");
			String custName = sc.nextLine();
			System.out.println("Enter Balance:");
			float bal = Float.parseFloat(sc.nextLine());
			System.out.println("Enter AccType:");
			String accType = sc.nextLine();
			System.out.println("Enter Address:");
			String addr = sc.nextLine();
			System.out.println("Enter Mail-ID:");
			String mId = sc.nextLine();
			System.out.println("Enter PhoneNo:");
			long phNo = Long.parseLong(sc.nextLine());
			CallableStatement cs = con.prepareCall("{call CustomerAccount38(?,?,?,?,?,?,?)}");
			
			cs.setLong(1, accNo);
			cs.setString(2, custName);
			cs.setFloat(3, bal);
			cs.setString(4, accType);
			cs.setString(5, addr);
			cs.setString(6, mId);
			cs.setLong(7, phNo);
			
			cs.execute();//Procedure execution
			System.out.println("Procedure executed Successfully...");
			sc.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
