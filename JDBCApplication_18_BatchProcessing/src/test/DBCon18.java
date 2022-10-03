package test;

import java.sql.*;

public class DBCon18 {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			Statement stm = con.createStatement();
			stm.addBatch("insert into Product38 values ('A444','Scale', 17.25,4)");
			stm.addBatch("insert into Emp38 values ('A222','Prem','Senior Con',13000)");
			int k[] = stm.executeBatch();
			for(int i=0;i<k.length;i++) {
				System.out.println("Data inserted successfully...");
			}//end of loop
			stm.clearBatch();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
