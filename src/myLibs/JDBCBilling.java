package myLibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class JDBCBilling extends Database {

	SimpleDateFormat dateformate = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String currentDate = dateformate.format(date);

	public ArrayList billing() {

		Connection conn;
		PreparedStatement pstat;
		ResultSet rs;
		ArrayList<BillingLibs> Billing = new ArrayList();

		String sql = " select booking2.B_Id, booking2.Arrivaldate, "
				+ "booking2.Departuredate, customer.Name, roomtest.Room_no,"
				+ " roomtest.Room_price, food.price, bar.bar_price, " + "service.s_Charge from booking2 join customer join "
				+ "roomtest join bar join food join service where "
				+ "booking2.C_Id = customer.C_Id and booking2.Room_no = "
				+ "roomtest.Room_no and bar.B_Id = booking2.B_Id and " + "food.B_Id = booking2.B_Id and service.B_Id = "
				+ "booking2.B_Id and booking2.bookingstatus='Active';";

		try {
			conn = connect();

			pstat = conn.prepareStatement(sql);

			rs = pstat.executeQuery();

			while (rs.next()) {
				BillingLibs billing = new BillingLibs(rs.getInt("B_Id"), rs.getString("Arrivaldate"),
						rs.getString("Departuredate"), rs.getString("Name"), rs.getInt("Room_no"),
						rs.getInt("Room_price"), rs.getInt("price"), rs.getInt("bar_price"), rs.getInt("s_Charge"));

				Billing.add(billing);

			}

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return Billing;

	}

	public boolean insertbilling(BillingLibs2 billing) {

		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String sql = "INSERT INTO checkout VALUES (?,?,?,?,?,?,?,?,?,?,?);";
		try {

			conn = connect();

			pstat = conn.prepareStatement(sql);

			pstat.setInt(1, billing.getBilling_ID());
			pstat.setString(2, billing.getName());
			pstat.setInt(3, billing.getDrink_Amount());
			pstat.setInt(4, billing.getService_Amount());
			pstat.setInt(5, billing.getFood_Amount());
			pstat.setInt(6, billing.getRoom_Amount());
			pstat.setDouble(7, billing.getTotal_Bill());
			pstat.setDouble(8, billing.getTotal_Paid());
			pstat.setDouble(9, billing.getReturn_Amount());
			pstat.setDouble(10, billing.getDiscount());
			pstat.setString(11, billing.getBilling_Status());

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

	
	public boolean update(bookinglibs3 booking) {

		Connection conn;
		PreparedStatement pstat;
		boolean result5 = false;
		String sql = "UPDATE booking2 SET bookingstatus = ? WHERE B_Id=?";
		try {

			conn = connect();

			pstat = conn.prepareStatement(sql);

			pstat.setString(1, booking.getBookingstatus());
			pstat.setInt(2, booking.getBookingid());

			pstat.executeUpdate();
			conn.close();
			pstat.close();
			result5 = true;

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result5;
	}

}
