package myLibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCBooking {
	public boolean insert(BookibgLibs booking) {
		// declare
		Connection conn;
		PreparedStatement pstat;// jdbc statement
		boolean result = false;
		String SQL = "INSERT INTO booking2 (B_Id,Arrivaldate,Departuredate,bookingtype,bookingstatus,C_ID) VALUES (?,?,?,?,?,?)";

		try {
			// input process output
			Class.forName("com.mysql.cj.jdbc.Driver");// 1.loading driver
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");// 2 connect

			pstat = conn.prepareStatement(SQL);// 3 create jdbc statment
			
			pstat.setInt(1, booking.getBookingid());
			pstat.setString(2, booking.getArrivaldate());// 4 set values
			pstat.setString(3, booking.getDeparturedate());
			pstat.setString(4, booking.getBookingtype());
			pstat.setString(5, booking.getBookingstatus());
			pstat.setInt(6, booking.getCustomerid());
			

			pstat.executeUpdate();// 5 running sql statement
			pstat.close();// 6.Close connection
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}

	public boolean update(BookibgLibs booking) {
		// declare
		Connection con;
		boolean res = false;
		String sql = "UPDATE booking2 SET  Arrivaldate = ?, Departuredate = ?, bookingtype = ? ,bookingstatus = ?, Room_no = ? WHERE B_Id=?";
		PreparedStatement pstat; // jdbc statement
		try {
			// input process output
			Class.forName("com.mysql.cj.jdbc.Driver");// 1.loading driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");// 2 connect
			pstat = con.prepareStatement(sql);// 3 create jdbc statment
			pstat.setString(1, booking.getArrivaldate());// 4 set values
			pstat.setString(2, booking.getDeparturedate());
			pstat.setString(3, booking.getBookingtype());
			pstat.setString(4, booking.getBookingstatus());
			pstat.setInt(5, booking.getBookingid());
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
	
	public boolean delete(int id) {
		// declare
		Connection con;
		boolean res = false;
		String sql = "DELETE FROM booking2 WHERE B_Id = ?";
		PreparedStatement pstat; // jdbc statement
		try {
			// input process output
			Class.forName("com.mysql.cj.jdbc.Driver");// 1.loading driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");// 2 connect
			pstat = con.prepareStatement(sql);// 3 create jdbc statment
			pstat.setInt(1, id);// 4 setvalues
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
		String sql="select customer.C_ID, customer.Name, booking2.B_Id, "
				+ "booking2.Arrivaldate, booking2.Departuredate, "
				+ "booking2.bookingtype, booking2.bookingstatus, "
				+ "booking2.Room_no  from booking2 left join customer"
				+ " on booking2.C_ID = customer.C_ID WHERE booking2.bookingstatus='Booked';";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel","root","");
			
			pstat=conn.prepareStatement(sql);
			
			//System.out.println(sql);
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
	
	public ArrayList customerselect_all() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList<bookinglibs3>a1=new ArrayList();
		String sql="select customer.C_ID, customer.Name, booking2.B_Id, "
				+ "booking2.Arrivaldate, booking2.Departuredate, "
				+ "booking2.bookingtype, booking2.bookingstatus, "
				+ "booking2.Room_no  from booking2 left join customer"
				+ " on booking2.C_ID = customer.C_ID WHERE customer.C_ID=?;";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel","root","");
			
			pstat=conn.prepareStatement(sql);
			pstat.setInt(1,Global.current_user.getID());
			//System.out.println(sql);
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

	public ArrayList reception_select() {
		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList<bookinglibs3>a2=new ArrayList();
		String sql="select customer.C_ID, customer.Name,booking2.B_Id, "
				+ "booking2.Arrivaldate, booking2.Departuredate, "
				+ "booking2.bookingtype, booking2.bookingstatus, "
				+ "booking2.Room_no from booking2 left join customer"
				+ " on booking2.C_ID = customer.C_ID;";
		
		
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
				
				a2.add(booking);
				
			}
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		return a2;
		
	}
	
	public boolean receptionUpdate (bookinglibs3 booking) {
		// declare
		Connection con;
		boolean res = false;
		String sql = "UPDATE booking2 SET bookingstatus = ?, Room_no = ? WHERE B_Id=?";
		PreparedStatement pstat; 
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");// 2 connect
			pstat = con.prepareStatement(sql);// 3 create jdbc statment
			
			pstat.setString(1, booking.getBookingstatus());
			pstat.setInt(2,booking.getRoomno());
			pstat.setInt(3, booking.getBookingid());
			
			pstat.executeUpdate();
			con.close();// 6.Close connection
			res = true;
		} catch (Exception ex) {			
			System.out.println("Error : " + ex.getMessage());
		}

		return res;
	}
	

}
