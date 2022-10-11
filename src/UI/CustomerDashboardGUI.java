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
import javax.swing.JComboBox;
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

import myLibs.BookibgLibs;
import myLibs.Global;
import myLibs.JDBCBooking;
import myLibs.bookinglibs3;

public class CustomerDashboardGUI implements MouseListener {
	JFrame frame;
	JButton logoutbtn;
	Object[] columnsName, column;
	DefaultTableModel model, model2;
	JTable table, table2;
	JComboBox bookingtypetxt;
	JDateChooser checkintxt, checkouttxt;
	JTextField customeridtxt, bookingidtxt;
	ArrayList<bookinglibs3> a1;
	JButton insertbtn;

	//default constructor to set the contents of frame
	public CustomerDashboardGUI() {
		frame = new JFrame("Customer Dasboard");
		frame.setSize(950, 600);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout());

		//innitialize and memory allocation
		// +++++++++++++++++North Panel+++++++++++++++=
		JPanel northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setPreferredSize(new Dimension(100, 90));
		northPanel.setBackground(new Color(85, 168, 235));
		frame.add(northPanel, BorderLayout.NORTH);

		JLabel title = new JLabel("Customer Dashboard");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setBounds(500, 30, 350, 30);
		northPanel.add(title);

		// ++++++++++++++++=Tab Panel++++++++++
		JTabbedPane tab = new JTabbedPane();
		tab.setPreferredSize(new Dimension(100, 250));
		tab.setBackground(new Color(105, 107, 108));
		frame.add(tab, BorderLayout.CENTER);

		// *********************First Panel****************8
		JPanel customerPanel = new JPanel();
		customerPanel.setLayout(new BorderLayout());
		customerPanel.setPreferredSize(new Dimension(100, 250));
		customerPanel.setBackground(new Color(105, 107, 108));
		tab.add("Check Booking", customerPanel);

		// +++++++++++++++West Panel+++++++++++++++
		JPanel westPanel = new JPanel();
		westPanel.setLayout(null);
		westPanel.setPreferredSize(new Dimension(400, 90));
		westPanel.setBackground(new Color(105, 105, 105));
		customerPanel.add(westPanel, BorderLayout.WEST);



		bookingidtxt = new JTextField();

		JLabel customeridlbl = new JLabel("Customer ID:");
		customeridlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		customeridlbl.setBounds(10, 30, 150, 30);
		westPanel.add(customeridlbl);

		customeridtxt = new JTextField();
		customeridtxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		customeridtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		customeridtxt.setBounds(150, 30, 200, 30);
		customeridtxt.setText(Integer.toString(Global.current_user.getID()));
		customeridtxt.setEditable(false);
		westPanel.add(customeridtxt);

		JLabel checkinlbl = new JLabel("Check In:");
		checkinlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		checkinlbl.setBounds(10, 90, 150, 30);
		westPanel.add(checkinlbl);

		Date date = new Date();
		checkintxt = new JDateChooser();
		checkintxt.setMinSelectableDate(date);
		checkintxt.setDateFormatString("yyyy-MM-dd");
		checkintxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		checkintxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		checkintxt.setBounds(150, 90, 200, 30);
		westPanel.add(checkintxt);

		JLabel checkoutlbl = new JLabel("Check Out:");
		checkoutlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		checkoutlbl.setBounds(10, 150, 150, 30);
		westPanel.add(checkoutlbl);
		
        Date date2 = new Date();
		checkouttxt = new JDateChooser();
		checkouttxt.setMinSelectableDate(date2);
		checkouttxt.setDateFormatString("yyyy-MM-dd");
		checkouttxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		checkouttxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		checkouttxt.setBounds(150, 150, 200, 30);
		westPanel.add(checkouttxt);

		JLabel bookingtypelbl = new JLabel("Room Type:");
		bookingtypelbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		bookingtypelbl.setBounds(10, 210, 150, 30);
		westPanel.add(bookingtypelbl);

		Object[] h1 = { "Single", "Twin", "Double" };
		bookingtypetxt = new JComboBox(h1);
		bookingtypetxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bookingtypetxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		bookingtypetxt.setBounds(150, 210, 200, 30);
		westPanel.add(bookingtypetxt);

		insertbtn = new JButton("Request Booking");
		insertbtn.setBackground(new Color(105, 105, 105));
		insertbtn.setFocusable(false);
		insertbtn.setForeground(Color.white);
		insertbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		insertbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		insertbtn.setBounds(150, 270, 200, 30);
		westPanel.add(insertbtn);
		insertbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				BookibgLibs booking = new BookibgLibs();

				int id = Integer.parseInt(customeridtxt.getText());

				String date1 = ((JTextField) checkintxt.getDateEditor().getUiComponent()).getText();

				String date2 = ((JTextField) checkouttxt.getDateEditor().getUiComponent()).getText();

				String type = bookingtypetxt.getSelectedItem().toString();

				booking.setCustomerid(id);
				booking.setArrivaldate(date1);
				booking.setDeparturedate(date2);
				booking.setBookingtype(type);
				booking.setBookingstatus("Pending");

				JDBCBooking jdbc = new JDBCBooking();
				boolean result = jdbc.insert(booking);
				if (result == true) {
					updateTable();
					JOptionPane.showMessageDialog(null, "Booking requested successfully");
				} else {
					JOptionPane.showMessageDialog(null, "Error!");

				}
			}

		});

		JButton cancelbtn = new JButton("Cancel Booking");
		cancelbtn.setBackground(new Color(105, 105, 105));
		cancelbtn.setFocusable(false);
		cancelbtn.setForeground(Color.white);
		cancelbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		cancelbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		cancelbtn.setBounds(150, 320, 200, 30);
		westPanel.add(cancelbtn);
		cancelbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int bookingid5 = Integer.parseInt(bookingidtxt.getText());

				JDBCBooking jdbc = new JDBCBooking();
				boolean result = jdbc.delete(bookingid5);
				if (result == true) {
					updateTable();
					JOptionPane.showMessageDialog(null, "The booking is cancelled");
				} else {
					JOptionPane.showMessageDialog(null, "Error");
				}

			}

		});

		// ****************Customer Booking Table**************
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
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);
		updateTable();
		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setBounds(400, 20, 500, 400);
		table.addMouseListener(this);
		customerPanel.add(scroll1, BorderLayout.CENTER);



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

		frame.setVisible(true);

	}

	public void updateTable() {

		JDBCBooking booking = new JDBCBooking();
		ArrayList select = booking.customerselect_all();

		model.setRowCount(0);
		if (select.size() > 0) {

			for (int i = 0; i < select.size(); i++) {
				bookinglibs3 tmp_person = (bookinglibs3) select.get(i);

				Vector tmpPerson = new Vector();

				tmpPerson.add(tmp_person.getCustomerid());
				tmpPerson.add(tmp_person.getName());
				tmpPerson.add(tmp_person.getBookingid());
				tmpPerson.add(tmp_person.getArrivaldate());
				tmpPerson.add(tmp_person.getDeparturedate());
				tmpPerson.add(tmp_person.getBookingtype());
				tmpPerson.add(tmp_person.getRoomno());
				tmpPerson.add(tmp_person.getBookingstatus());

				model.addRow(tmpPerson);
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		try {
			int h5 = table.getSelectedRow();

			TableModel model = table.getModel();

			String bookingid = model.getValueAt(h5, 2).toString();
			bookingidtxt.setText(bookingid);

			String id = model.getValueAt(h5, 0).toString();
			customeridtxt.setText(id);

			String type = model.getValueAt(h5, 5).toString();
			bookingtypetxt.setSelectedItem(type);

			Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(h5, 3));
			checkintxt.setDate(date);

			Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model.getValueAt(h5, 4));
			checkouttxt.setDate(date2);

		} catch (Exception ex) {
			System.out.println("Error" + ex.getMessage());
		}

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

	//main method to run the program
	public static void main(String[] args) {
		new CustomerDashboardGUI();

	}

}
