package myLibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCcheckin {
	
	public boolean update(bookinglibs3 booking) {
		// declare
		Connection con;
		boolean res = false;
		String sql = "UPDATE booking2 SET bookingstatus = ? WHERE B_Id=?";
		PreparedStatement pstat; // jdbc statement
		try {
			// input process output
			Class.forName("com.mysql.cj.jdbc.Driver");// 1.loading driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");// 2 connect
			pstat = con.prepareStatement(sql);// 3 create jdbc statment
			// 4 set values
			pstat.setString(1, booking.getBookingstatus());
			
			pstat.setInt(2, booking.getBookingid());
			pstat.executeUpdate();// 5 running sql statement
			con.close();// 6.Close connection
			res = true;
		} catch (Exception ex) {
			res = false;
			// error message
			System.out.println("Error : " + ex.getMessage());
		}

		return res;
	}
	
	public ArrayList select_all() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList<bookinglibs3>a1=new ArrayList();
		String sql="SELECT * FROM booking2";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel","root","");
			
			pstat=conn.prepareStatement(sql);
		
			rs=pstat.executeQuery();
			
			while(rs.next()) {
				bookinglibs3 booking=new bookinglibs3
						(rs.getInt("C_Id"),
						rs.getString("Name"),
						rs.getInt("B_Id"),
						rs.getString("Arrivaldate"),
						rs.getString("Departuredate"),
						rs.getString("bookingtype"),
						rs.getString("bookingstatus"),
						rs.getInt("Room_no")
						);
				
				a1.add(booking);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return a1;
		
	}


}
