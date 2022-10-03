package test;
import java.sql.*;
import java.util.*;
public class DBCon13 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			System.out.println("Enter Employee ID:");
			String eId = sc.nextLine();
			System.out.println("Enter Emplyee Name");
			String eName = sc.nextLine();
			System.out.println("Enter Employee Designation");
			String eDesg = sc.nextLine();
			System.out.println("Enter House No");
			String hNo = sc.nextLine();
			System.out.println("Enter Street Name");
			String sName = sc.nextLine();
			System.out.println("Enter City Name");
			String city = sc.nextLine();
			System.out.println("Enter PIN Code");
			int pinCode = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Mail-ID");
			String mId = sc.nextLine();
			System.out.println("Enter Phone Number:");
			long phNo = Long.parseLong(sc.nextLine());
			System.out.println("Enter Basic Salary:");
			float bSal = Float.parseFloat(sc.nextLine());
			float totSal = (float) (bSal+(.93*bSal)+(.63*bSal));
			
			CallableStatement cs = con.prepareCall("{call EmployeeAccount38(?,?,?,?,?,?,?,?,?,?,?)}");
			
			cs.setString(1, eId);
			cs.setString(2, eName);
			cs.setString(3, eDesg);
			cs.setString(4, hNo);
			cs.setString(5, sName);
			cs.setString(6, city);
			cs.setInt(7, pinCode);
			cs.setString(8, mId);
			cs.setLong(9, phNo);
			cs.setFloat(10, bSal);
			cs.setFloat(11, totSal);
			
			cs.execute();
			
			System.out.println("Procedure executed Successfully...");
			sc.close();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
