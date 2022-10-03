package test;
import java.sql.*;
import java.util.*;
public class Pooling {
	public String url,uName,pWord;
	public Vector <Connection> v = new Vector<Connection>(); //Vector Object holding Connection Objects
	public Pooling (String url, String uName, String pWord) {
		this.url = url;
		this.uName = uName;
		this.pWord = pWord;
	}
	public void createConnection() {
		try {
			while(v.size() < 5) {
				System.out.println("Pool is not Full..");
				Connection con = DriverManager.getConnection(url,uName,pWord);
				v.addElement(con);//Adding to the Vector Object
				System.out.println(con);
			}//end of loop
			if(v.size()==5) {
				System.out.println("Pool is Full...");
			}
		}//end of try
		catch (Exception e) {
			e.getMessage();
		}
	}//end of method
	
	public synchronized Connection takeConnection() {
		Connection con = v.elementAt(0);
		v.removeElementAt(0);
		return con;
	}
	
	public synchronized void returnConnection(Connection con) {
		v.addElement(con);//adding to the Pool
		System.out.println("Connection added back to the Pool...");
	}
}
