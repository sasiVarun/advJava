package test;
import javax.sql.rowset.*;
public class DBCon20 {
	public static void main(String[] args) {
		try {
			
			RowSetFactory rsf = RowSetProvider.newFactory();
			JdbcRowSet jrs = rsf.createJdbcRowSet();
			jrs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			jrs.setUsername("system");
			jrs.setPassword("admin");
			jrs.setCommand("select * from Product38");
			jrs.execute();
			System.out.println("===Display the records in reverse===");
			jrs.afterLast();
			while(jrs.previous()) {
				System.out.println(jrs.getString(1)+"\t"+jrs.getString(2)+"\t"+jrs.getFloat(3)+"\t"+jrs.getInt(4));
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
