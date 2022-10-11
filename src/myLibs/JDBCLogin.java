package myLibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCLogin {
	
	public LoginLibs login(LoginLibs user) {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		String sql="SELECT * FROM customer WHERE Username=? AND Password=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel","root","");
			
			pstat=conn.prepareStatement(sql);
			
			pstat.setString(1, user.getUsername());
			pstat.setString(2, user.getPassword());
			
			rs=pstat.executeQuery();
			while(rs.next()) {
				
				user.setID(rs.getInt("C_ID"));
				user.setUsername(rs.getString("Username"));
				user.setPassword(rs.getString("Password"));
				user.setRole(rs.getString("Role"));
			
			}
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return user;
	}

}
