package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import myLibs.JDBCBooking;
import myLibs.JDBCroom;
import myLibs.bookinglibs3;
import myLibs.roomLibs;

public class ReceptionDashboard implements MouseListener {

	protected static final Color COLOR = null;
	JFrame frame;
	JButton logoutbtn;
	JDateChooser checkintxt,checkouttxt;
	JTextField customeridtxt,bookingidtxt, bookingtypetxt,roomidtxt ;
	JButton insertbtn;
	Object[] columnsName;
	DefaultTableModel model;
	JTable table;
	ArrayList<bookinglibs3>a2;

	public ReceptionDashboard() {
		frame = new JFrame("Reception Dasboard");
		frame.setSize(950, 600);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout());

		// +++++++++++++++++North Panel+++++++++++++++=
		JPanel northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setPreferredSize(new Dimension(100, 90));
		northPanel.setBackground(new Color(85,168,235));
		frame.add(northPanel, BorderLayout.NORTH);

		JLabel title = new JLabel("Reception Dashboard");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setBounds(500, 30, 350, 30);
		northPanel.add(title);

		logoutbtn = new JButton("Logout");
		logoutbtn.setBackground(new Color(255, 255, 255, 100));
		logoutbtn.setOpaque(true);
		logoutbtn.setFocusable(false);
		logoutbtn.setForeground(Color.WHITE);
		logoutbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		logoutbtn.setBounds(20, 30, 120, 30);
		northPanel.add(logoutbtn);
		logoutbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new login();
				
			}

		});

		// +++++++++++++++West Panel+++++++++++++++
		JPanel westPanel = new JPanel();
		westPanel.setLayout(null);
		westPanel.setPreferredSize(new Dimension(400, 90));
		westPanel.setBackground(new Color(105, 105, 105));
		frame.add(westPanel, BorderLayout.WEST);

		JPanel westPanel1 = new JPanel();
		westPanel1.setLayout(null);
		westPanel1.setBounds(20, 20, 360, 520);
		westPanel1.setBackground(new Color(255, 255, 255, 100));
		westPanel.add(westPanel1);
		
		JLabel customeridlbl = new JLabel("Booking ID:");		
		customeridlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		customeridlbl.setBounds(10, 30, 150, 30);
		westPanel1.add(customeridlbl);
		
		bookingidtxt = new JTextField();		
		bookingidtxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bookingidtxt.setBorder(BorderFactory.createLineBorder(Color.white,1));
		bookingidtxt.setBounds(150, 30, 200, 30);
		westPanel1.add(bookingidtxt);
		
//		try {
//			// input process output
//			Class.forName("com.mysql.cj.jdbc.Driver");// 1.loading driver
//			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lutonhotel", "root", "");// 2 connect
//
//			String sql="select customer.C_ID, customer.Name, booking2.B_Id, "
//					+ "booking2.Arrivaldate, booking2.Departuredate, "
//					+ "booking2.bookingtype, booking2.bookingstatus, "
//					+ "booking2.Room_no  from booking2 left join customer"
//					+ " on booking2.C_ID = customer.C_ID;";
//			
//		
//			PreparedStatement pst1 = conn.prepareStatement(sql);
//			ResultSet rst1 = pst1.executeQuery();
//			
//			String B_Id = "";
//			while (rst1.next()) {
//				
//				bookingidtxt.addItem(rst1.getString("B_Id"));
//			}
//
//		} catch (Exception ex) {
//			JOptionPane.showMessageDialog(null, ex);
//		}
//			
//		
		
		JLabel checkinlbl = new JLabel("Check In:");		
		checkinlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		checkinlbl.setBounds(10, 90, 150, 30);
		westPanel1.add(checkinlbl);
		
		checkintxt = new JDateChooser();
		checkintxt.setDateFormatString("yyyy-MM-dd");
		checkintxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		checkintxt.setBorder(BorderFactory.createLineBorder(Color.white,1));
		checkintxt.setBounds(150, 90, 200, 30);
		westPanel1.add(checkintxt);
		
		JLabel checkoutlbl = new JLabel("Check Out:");		
		checkoutlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		checkoutlbl.setBounds(10, 150, 150, 30);
		westPanel1.add(checkoutlbl);
		
		checkouttxt = new JDateChooser();
		checkouttxt.setDateFormatString("yyyy-MM-dd");
		checkouttxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		checkouttxt.setBorder(BorderFactory.createLineBorder(Color.white,1));
		checkouttxt.setBounds(150, 150, 200, 30);
		westPanel1.add(checkouttxt);
		
		
		
		JLabel roomnolbl = new JLabel("Room No:");		
		roomnolbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		roomnolbl.setBounds(10, 210, 150, 30);
		westPanel1.add(roomnolbl);
		
		roomidtxt = new JTextField();		
		roomidtxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		roomidtxt.setBorder(BorderFactory.createLineBorder(Color.white,1));
		roomidtxt.setBounds(150, 210, 200, 30);
		westPanel1.add(roomidtxt);
		

		
		
			
		insertbtn = new JButton("Confirm Booking");	
		insertbtn.setBackground(new Color(105,105,105));
		insertbtn.setFocusable(false);
		insertbtn.setForeground(Color.white);
		insertbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		insertbtn.setBorder(BorderFactory.createLineBorder(Color.white,1));
		insertbtn.setBounds(150, 270, 200, 30);
		westPanel1.add(insertbtn);
		insertbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				//Update Room Status
				roomLibs room=new roomLibs();
				
	      	    int Roomid= Integer.parseInt(roomidtxt.getText());
		
        		room.setRoom_no(Roomid);
				room.setRoom_status("Booked");
				
				JDBCroom jdbc=new JDBCroom();
				boolean result2=jdbc.receptionupdate(room);
				
				//Confirm Booking JDBC
				
				bookinglibs3 booking=new bookinglibs3();
				
				int id=Integer.parseInt(bookingidtxt.getText());
				int Roomid2=Integer.parseInt(roomidtxt.getText());
							
				
				
				booking.setBookingid(id);
				booking.setRoomno(Roomid2);
				booking.setBookingstatus("Booked");
				
				JDBCBooking jdbc2=new JDBCBooking();
				boolean res=jdbc2.receptionUpdate(booking);
				if(res==true) {
					updateTable();
					JOptionPane.showMessageDialog(null,"Booked successfully");
				}
				else {
					JOptionPane.showMessageDialog(null,"Error!");
					
				}
			}
			
			
		});
		
		
		
		JButton availableroom = new JButton("Available room");	
		availableroom.setBackground(new Color(105,105,105));
		availableroom.setFocusable(false);
		availableroom.setForeground(Color.white);
		availableroom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		availableroom.setBorder(BorderFactory.createLineBorder(Color.white,1));
		availableroom.setBounds(150, 330, 200, 30);
		westPanel1.add(availableroom);
		availableroom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new AvailableRoomGUI();
				
			}

		});
		
		
		
		

		// ++++++++++++++++=Center Panel++++++++++
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBounds(20, 20, 360, 520);
		centerPanel.setBackground(new Color(255, 255, 255, 100));
		frame.add(centerPanel, BorderLayout.CENTER);

		columnsName = new Object[8];
		columnsName[0] = "Customer ID";
		columnsName[1] = "Name";
		columnsName[2] = "Booking ID";
		columnsName[3] = "Arrival Date";
		columnsName[4] = "Departure Date";
		columnsName[5] = "Booking Type";
		columnsName[6] = "Room No";
		columnsName[7] = "Booking Status";

		table = new JTable();
		table.addMouseListener(this);
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);
		updateTable();
		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setBounds(400, 20, 500, 400);
		centerPanel.add(scroll1, BorderLayout.CENTER);

		// ++++++++++++++++=SOUTH Panel++++++++++
		JTabbedPane southPanelTab = new JTabbedPane();
		southPanelTab.setPreferredSize(new Dimension(100,250));
		southPanelTab.setBackground(new Color(105,107,108));
		centerPanel.add(southPanelTab, BorderLayout.SOUTH);
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(null);
		southPanel.setPreferredSize(new Dimension(100,250));
		southPanel.setBackground(new Color(105,107,108));
		southPanelTab.add("Services",southPanel);
		
		JButton manageroom=new JButton("Manage Room");
		manageroom.setFocusable(false);
		manageroom.setFont(new Font("Tahoma",Font.BOLD,18));
		manageroom.setBounds(20,10,250,200);
		southPanel.add(manageroom);
		manageroom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Room();
				
			}
			
			
		});
		
		JButton checkinroom=new JButton("check in");
		checkinroom.setFocusable(false);
		checkinroom.setFont(new Font("Tahoma",Font.BOLD,18));
		checkinroom.setBounds(300,10,250,200);
		southPanel.add(checkinroom);
		checkinroom.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new checkinform();
				
			}
			
			
		});
		
		JButton customerbtn=new JButton("Manage Customers");
		customerbtn.setFocusable(false);
		customerbtn.setFont(new Font("Tahoma",Font.BOLD,18));
		customerbtn.setBounds(600,10,250,200);
		southPanel.add(customerbtn);
		customerbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new CustomerManagement();
				
			}
			
			
		});
		
		
		JPanel southPanel2 = new JPanel();
		southPanel2.setLayout(null);
		southPanel2.setPreferredSize(new Dimension(100,250));
		southPanel2.setBackground(new Color(105,107,108));
		southPanelTab.add("Services 2",southPanel2);
		
		JButton corporatebtn=new JButton("Manage Corp Cust");
		corporatebtn.setFocusable(false);
		corporatebtn.setFont(new Font("Tahoma",Font.BOLD,18));
		corporatebtn.setBounds(20,10,250,200);
		southPanel2.add(corporatebtn);
		corporatebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new CorporateCustomerManagement();
				
			}
			
			
		});
		
		JButton resturenbtn=new JButton("Restaurent");
		resturenbtn.setFocusable(false);
		resturenbtn.setFont(new Font("Tahoma",Font.BOLD,18));
		resturenbtn.setBounds(300,10,250,200);
		southPanel2.add(resturenbtn);
		resturenbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Restaurent();
			}
			
			
		});
		
		
		
		JButton barbtn=new JButton("Bar");
		barbtn.setFocusable(false);
		barbtn.setFont(new Font("Tahoma",Font.BOLD,18));
		barbtn.setBounds(600,10,250,200);
		southPanel2.add(barbtn);
		barbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Bar();
				
			}
		});
				
		
	
		
		JPanel southPanel3 = new JPanel();
		southPanel3.setLayout(null);
		southPanel3.setPreferredSize(new Dimension(100,250));
		southPanel3.setBackground(new Color(105,107,108));
		southPanelTab.add("Services 3",southPanel3);
		
		
		JButton servicebtn=new JButton("Es-service");
		servicebtn.setFocusable(false);
		servicebtn.setFont(new Font("Tahoma",Font.BOLD,18));
		servicebtn.setBounds(20,10,250,200);
		southPanel3.add(servicebtn);
		servicebtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Service();
				
			}
		});
		
		JButton Billing=new JButton("Bill");
		Billing.setFocusable(false);
		Billing.setFont(new Font("Tahoma",Font.BOLD,18));
		Billing.setBounds(600,10,250,200);
		southPanel3.add(Billing);
		Billing.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Billing();
				
			}
		});
		
		
		JButton Staff=new JButton("ManageStaff");
		Staff.setFocusable(false);
		Staff.setFont(new Font("Tahoma",Font.BOLD,18));
		Staff.setBounds(300,10,250,200);
		southPanel3.add(Staff);
		Staff.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new Registration2();
				
			}
		});
		
		

		frame.setVisible(true);

	}
	
	public void updateTable() {
		JDBCBooking jdbc2 = new JDBCBooking();
		ArrayList select = jdbc2.reception_select();
		model.setRowCount(0);
		if(select.size()>0) {
		
			for(int i = 0; i< select.size(); i++) {
		
		bookinglibs3 bookingLibs = (bookinglibs3) select.get(i);  
		Vector tmpPerson = new Vector();
		
		
		tmpPerson.add(bookingLibs.getCustomerid());
		tmpPerson.add(bookingLibs.getName());
		tmpPerson.add(bookingLibs.getBookingid());
		tmpPerson.add(bookingLibs.getArrivaldate());
		tmpPerson.add(bookingLibs.getDeparturedate());
		tmpPerson.add(bookingLibs.getBookingtype());
		tmpPerson.add(bookingLibs.getRoomno());
		tmpPerson.add(bookingLibs.getBookingstatus());


			model.addRow(tmpPerson);
			}
		}
	}
		
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		try {
			int h5=table.getSelectedRow();
			
			TableModel model=table.getModel();
			
			String bookingid=model.getValueAt(h5,2).toString();
			bookingidtxt.setText(bookingid);
			
			
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(h5, 3));
			checkintxt.setDate(date);
			
			Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String)model.getValueAt(h5, 4));
			checkouttxt.setDate(date2);
			
			
			
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
		}
		
		
		
		
	}

	public static void main(String[] args) {
		new ReceptionDashboard();

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
