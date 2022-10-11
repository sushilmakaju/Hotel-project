package myLibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCbar {
	
	public boolean insert(barlibs food) {
		// declare
		Connection conn;
		PreparedStatement pstat;// jdbc statement
		boolean result = false;
		String SQL = "INSERT INTO bar (B_Id,bar_item,bar_price) VALUES (?,?,?)";

		try {
			// input process output
			Class.forName("com.mysql.cj.jdbc.Driver");// 1.loading driver
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");// 2 connect

			pstat = conn.prepareStatement(SQL);// 3 create jdbc statment
			
			pstat.setInt(1, food.getBookingid());
			pstat.setString(2, food.getBaritem());// 4 set values
			pstat.setInt(3, food.getPrice());
			
		
			

			pstat.executeUpdate();// 5 running sql statement
			pstat.close();// 6.Close connection
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}
	
	public ArrayList select_all() {
		String sql = "SELECT * FROM bar ";
		ArrayList<barlibs> a1 = new ArrayList();// collection
		try {
			// 1.Connect with database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");// connect
																												// Driver
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				barlibs res = new barlibs
						(rs.getInt("bar_id"),
						 rs.getString("bar_item"),
						 rs.getInt("bar_price"),
						 rs.getInt("B_Id"));
				a1.add(res);
						
			}
			rs.close();
			pstat.close();
			con.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return a1;
	}
	

}


