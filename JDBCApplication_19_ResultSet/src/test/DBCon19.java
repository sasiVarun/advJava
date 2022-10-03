package test;
import java.sql.*;
public class DBCon19 {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			
			System.out.println("*****Using Statement*****");
			
			Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs1 = stm.executeQuery("select * from product38");
			System.out.println("===Display Product details in reverse===");
			rs1.afterLast();//Moving the cursor to last
			
			while(rs1.previous()) {
				System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getFloat(3)+"\t"+rs1.getInt(4));
			}//end of loop
			System.out.println("*****Using PreparedStatement*****");
			
			PreparedStatement ps = con.prepareStatement("select * from emp38",1004,1007);
			ResultSet rs2 = ps.executeQuery();
			System.out.println("===Display the record  at row number 2===");
			rs2.absolute(2);//Moving cursor to row 2
			System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t+"+rs2.getString(3)+"\t"+rs2.getFloat(4));
			rs2.relative(+2);//Moving cursor to current row plus 2 rows.
			System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t+"+rs2.getString(3)+"\t"+rs2.getFloat(4));
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
