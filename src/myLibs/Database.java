package myLibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class Database {
	
	
	public Connection connect() {
		Connection conn = null;
		PreparedStatement pstat;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");
			
			
		}
		
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		return conn;
		
	}

}
