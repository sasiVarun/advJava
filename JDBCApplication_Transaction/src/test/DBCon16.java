package test;
import java.sql.*;
import java.util.Scanner;

public class DBCon16 {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			PreparedStatement ps1 = con.prepareStatement("select * from Bank38 where accno = ?");
			PreparedStatement ps2 = con.prepareStatement("update Bank38 set balance=balance+? where accno = ?");
			
			System.out.println("Commit_Status: "+ con.getAutoCommit());
			con.setAutoCommit(false);// Stopping AutoCommit Operation
			System.out.println("Commit_Status: "+ con.getAutoCommit());
			Savepoint sp = con.setSavepoint();
			
			System.out.println("Enter accno:(HomeAccNo):");
			long hAccNo = sc.nextLong();
			ps1.setLong(1, hAccNo);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1.next()) {
				float bal = rs1.getFloat(3);//Getting available balance from Home Account No
				System.out.println("Enter Benificiary Account No:");
				long bAccNo = sc.nextLong();
				ps1.setLong(1, bAccNo);
				ResultSet rs2 = ps1.executeQuery();
				if(rs2.next()) {
					System.out.println("Enter amount to be transfered:");
					float amt = sc.nextFloat();
					if(amt<=bal) {
						ps2.setFloat(1, -amt);
						ps2.setLong(2, hAccNo);
						int i = ps2.executeUpdate();//Buffer Updated
						
						ps2.setFloat(1, amt);
						ps2.setLong(2, bAccNo);
						int j = ps2.executeUpdate();//Buffer Updated
						
						if(i==1 && j==1) {
							System.out.println("Transaction Successfull");
							con.commit();
						} else {
							con.rollback(sp);
						}
					} else {
						System.out.println("Transaction Failed");
						System.out.println("Insufficient funds..");
					}
				} else {
					System.out.println("Invalid Benificary Account No...");
				}
			}else {
				System.out.println("Invalid Home Account No...");
			}
			sc.close();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
