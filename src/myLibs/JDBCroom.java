package myLibs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class JDBCroom {
	public boolean insert(roomLibs room) {

		Connection conn;
		PreparedStatement pstat;
		boolean result = false;
		String SQL = "INSERT INTO roomtest(Room_no,Room_type,Room_price,Room_status) VALUES (?,?,?,?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");

			pstat = conn.prepareStatement(SQL);
			
			pstat.setInt(1, room.getRoom_no());
			pstat.setString(2, room.getRoom_type());
			pstat.setDouble(3, room.getPrice());
			pstat.setString(4, room.getRoom_status());

			pstat.executeUpdate();
			pstat.close();
			conn.close();
			result = true;
		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}
		return result;

	}

		public boolean update(roomLibs room) {

			Connection conn;
			PreparedStatement pstat;
			boolean result = false;
			String SQL = "UPDATE INTO roomtest(Room_no,Room_type,Room_price,Room_status) VALUES (?,?,?,?)";

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");

				pstat = conn.prepareStatement(SQL);
				
				pstat.setInt(1, room.getRoom_no());
				pstat.setString(2, room.getRoom_type());
				pstat.setDouble(3, room.getPrice());
				pstat.setString(4, room.getRoom_status());

				pstat.executeUpdate();
				pstat.close();
				conn.close();
				result = true;
			} catch (Exception ex) {
				System.out.println("Error" + ex.getMessage());
			}
			return result;

		}
		
		//search
		
		public roomLibs search(roomLibs room) {
			Connection con;
			PreparedStatement pstat;
			ResultSet rs;
			String sql = "SELECT * FROM roomtest WHERE Room_no = ?";
			roomLibs tmpPerson = new roomLibs();

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");
				pstat = conn.prepareStatement(sql);
				pstat.setInt(1, room.getRoom_no());
				rs = pstat.executeQuery();
				while (rs.next()) {
					tmpPerson = new roomLibs(rs.getInt("room_no"), rs.getString("room_type"), rs.getString("room_status"), rs.getDouble("price"));
				}
				rs.close();
				pstat.close();
				conn.close();

			} catch (Exception ex) {
				System.out.println("Error : " + ex.getMessage());
				return tmpPerson;
			}
			return tmpPerson;
		}
		
		public boolean receptionupdate(roomLibs room) {

			Connection conn;
			PreparedStatement pstat;
			boolean result2 = false;
			String SQL = "UPDATE roomtest SET Room_status=? WHERE Room_no=?;";

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");

				pstat = conn.prepareStatement(SQL);

				pstat.setString(1, room.getRoom_status());
				pstat.setInt(2, room.getRoom_no());

				pstat.executeUpdate();
				pstat.close();
				conn.close();
				result2 = true;
			} catch (Exception ex) {
				System.out.println("Error" + ex.getMessage());
			}
			return result2;

	}
		
		//Available room
		public ArrayList searchAvailableRoom() {
			Connection con;
			PreparedStatement pstat;
			ResultSet rs;
			String sql = "SELECT * FROM roomtest WHERE Room_status = 'Available'";
			ArrayList<RoomLibs2>tmpPerson = new ArrayList();

			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");
				pstat = conn.prepareStatement(sql);
				
				rs = pstat.executeQuery();
				while (rs.next()) {
					RoomLibs2 room = new RoomLibs2
							(rs.getInt("Room_no"),
							rs.getString("Room_type"), 
							rs.getDouble("Room_price"),
							rs.getString("Room_status"));
					
					tmpPerson.add(room);
				}
				
				
				rs.close();
				pstat.close();
				conn.close();

			} catch (Exception ex) {
				System.out.println("Error : " + ex.getMessage());
				
			}
			return tmpPerson;
		}

	}




