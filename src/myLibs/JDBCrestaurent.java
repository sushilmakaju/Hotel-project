package myLibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCrestaurent {
	public boolean insert(restaurentlibs food) {
		// declare
		Connection conn;
		PreparedStatement pstat;// jdbc statement
		boolean result = false;
		String SQL = "INSERT INTO food VALUES (?,?,?,?)";

		try {
			// input process output
			Class.forName("com.mysql.cj.jdbc.Driver");// 1.loading driver
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");// 2 connect

			pstat = conn.prepareStatement(SQL);// 3 create jdbc statment
			
			pstat.setInt(1, food.getFoodid());
			pstat.setString(2, food.getFooditem());// 4 set values
			pstat.setInt(3, food.getPrice());
			pstat.setInt(4,food.getBookingid());
			
		
			

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
		String sql = "SELECT * FROM food ";
		ArrayList<restaurentlibs> a1 = new ArrayList();// collection
		try {
			// 1.Connect with database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");// connect
																												// Driver
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				restaurentlibs res = new restaurentlibs
						(rs.getInt("Food_id"),
						 rs.getString("food_item"),
						 rs.getInt("price"),
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
