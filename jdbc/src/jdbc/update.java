package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class update {
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
		        System.out.println("enter tablename");
				String sql="update "+s.next()+ " set id=?,name=?,email=?,password=? where id=?";
			    pmst=conn.prepareStatement(sql);
			    pmst.setInt(1, s.nextInt());
			    pmst.setString(2, s.next());
			    pmst.setString(3, s.next());
			    pmst.setString(4, s.next());
			    pmst.setInt(5, s.nextInt());
			    
			    int i=pmst.executeUpdate();
				if (i>0) {
					System.out.println("updated succesfully");
				}
				else {
					System.out.println("error");
				}
				conn.close();
				pmst.close();

		}
		catch(Exception e){
			e.printStackTrace();
				
			}

	}

}
