package myLibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCservice {

	public boolean insert(ServiceLibs service) {

		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "INSERT INTO service (B_Id, s_Type, s_Charge) VALUES (?, ?, ?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");

			pstat = conn.prepareStatement(sql);
			
			pstat.setInt(1, service.getBookingid());
			pstat.setString(2,service.getServicetype());// 4 set values
			pstat.setInt(3, service.getServiceprice());
			

			
			pstat.executeUpdate();

			conn.close();
			pstat.close();
			result = true;
		}

		catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;
	}
	
	public ArrayList select_all() {
		String sql = "SELECT * FROM service ";
		ArrayList<ServiceLibs> a1 = new ArrayList();// collection
		try {
			// 1.Connect with database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");// connect
																												// Driver
			PreparedStatement pstat = con.prepareStatement(sql);
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				ServiceLibs res = new ServiceLibs
						(rs.getInt("S_id"),
						 rs.getString("s_Type"),
						 rs.getInt("s_Charge"),
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
