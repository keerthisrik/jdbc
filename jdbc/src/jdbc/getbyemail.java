package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
public class getbyemail {
	private static final String Driver = "com.mysql.cj.jdbc.Driver";
    private static final String username = "root";
    private static final String password = "root";
    private static final String url = "jdbc:mysql://localhost:3306/student";
    private static Connection conn;
    private static PreparedStatement pmst;

    public static void main(String[] args) {
        try {
            Scanner s = new Scanner(System.in);
            Class.forName(Driver);
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Enter tablename:");
            String tableName = s.next();

            System.out.println("Enter email:");
            String email = s.next();

            String sql = "select * from " + tableName + " WHERE email=?";
            pmst = conn.prepareStatement(sql);
            pmst.setString(1, email);

            ResultSet rs = pmst.executeQuery();

            if (rs.next()) {
                System.out.println("id: " + rs.getInt("id"));
                System.out.println("name: " + rs.getString("name"));
                System.out.println("email: " + rs.getString("email"));
                System.out.println("password: " + rs.getString("password"));
            } else {
                System.out.println("No record found with id: " + email);
            }

            conn.close();
            pmst.close();
            s.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
