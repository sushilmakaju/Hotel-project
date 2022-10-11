package myLibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class JDBCRegistration {

	public boolean insert(RegistrationLibs registration) {

		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String SQL = "INSERT INTO customer VALUES (?,?,?,?,?,?,?,?,?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");

			pstat = conn.prepareStatement(SQL);

			pstat.setInt(1, registration.getID());
			pstat.setString(2, registration.getName());
			pstat.setString(3, registration.getEmail());
			pstat.setString(4, registration.getMobile());
			pstat.setString(5, registration.getAddress());
			pstat.setString(6, registration.getUsername());
			pstat.setString(7, registration.getPassword());
			pstat.setString(8, registration.getRole());
			pstat.setString(9, registration.getAccount());
			pstat.setString(10, registration.getCVC());

			pstat.executeUpdate();

			conn.close();
			pstat.close();
			result = true;

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}

	public ArrayList select_all() {
		String sql = "SELECT * FROM customer WHERE Role='Customer'";
		ArrayList<RegistrationLibs> a1 = new ArrayList();// collection
		try {
			// 1.Connect with database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");// connect
																												// Driver
			PreparedStatement pstat = con.prepareStatement(sql);
			
			
			ResultSet rs = pstat.executeQuery();
			while (rs.next()) {
				RegistrationLibs reg = new RegistrationLibs
					    (rs.getInt("C_ID"),
						rs.getString("Name"),
						rs.getString("Email"), 
						rs.getString("Mobile"),
						rs.getString("Address"),
						rs.getString("Username"),
						rs.getString("Password"),
						rs.getString("Role"),
						rs.getString("Account"),
						rs.getString("CVC"));
				a1.add(reg);
			}
			rs.close();
			pstat.close();
			con.close();
		} catch (Exception ex) {
			System.out.println("Error : " + ex.getMessage());
		}
		return a1;
	}
	
	public boolean update(RegistrationLibs registration) {
		// declare
		Connection con;
		boolean res = false;
		String sql = "UPDATE customer SET   Name = ?, Email = ? ,Mobile = ?, Address = ?, Username = ?, Password = ?, Role = ?, Account = ?, CVC = ? WHERE C_ID=?";
		PreparedStatement pstat; // jdbc statement
		try {
			// input process output
			Class.forName("com.mysql.cj.jdbc.Driver");// 1.loading driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");// 2 connect
			pstat = con.prepareStatement(sql);// 3 create jdbc statment
			pstat.setString(1, registration.getName());// 4 set values
			pstat.setString(2, registration.getEmail());
			pstat.setString(3, registration.getMobile());
			pstat.setString(4, registration.getAddress());
			pstat.setString(5, registration.getUsername());
			pstat.setString(6, registration.getPassword());
			pstat.setString(7, registration.getRole());
			pstat.setString(8, registration.getAccount());
			pstat.setString(9, registration.getCVC());
			pstat.setInt(10, registration.getID());

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
		String sql = "DELETE FROM customer WHERE C_ID = ?";
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
	

}
