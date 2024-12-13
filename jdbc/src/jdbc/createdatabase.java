package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class createdatabase {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/";
	private static final String user="root";
	private static final String password="root";
	private static Connection conn;
	private static PreparedStatement pmst;
public static void main(String[] args) {

try {
	    Scanner s=new Scanner(System.in);
		Class.forName(Driver);
        conn=DriverManager.getConnection(url,user,password);
		System.out.println("enter dbname:");
		String sql="drop database " +s.next();
		
		pmst=conn.prepareStatement(sql);
		int i=pmst.executeUpdate();
		if (i==0) {
			System.out.println("deleted succesfully");
		}
		else {
			System.out.println("error while deleting");
		}
}
	catch(Exception e){
	e.printStackTrace();
		
	}

}
}