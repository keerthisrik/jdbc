package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class login {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String username="root";
	private static final String password="root";
	private static final String url="jdbc:mysql://localhost:3306/student";
	private static Connection conn;
	private static PreparedStatement pmst;
	
public static void main(String[] args) {
	try {
		  Scanner s=new Scanner(System.in);
			Class.forName(Driver);
	        conn=DriverManager.getConnection(url,username,password);
	        System.out.println("enter email");
	        String email=s.next();
	        System.out.println("enter passwd");
	        String passwd=s.next();
			String sql="select * from studdetails"+" where email=? and password=?";
		    pmst=conn.prepareStatement(sql);
		    pmst.setString(1, email);
		    pmst.setString(2, passwd);
		    ResultSet rs=pmst.executeQuery();
		    if(rs.next()) {
		    System.out.println("successfully loged in");
		    }
		    else {
		    	System.out.println("invalid user");
		    }
			conn.close();
			pmst.close();
	}
	catch(Exception e){
		e.printStackTrace();
			
		}

}
}
