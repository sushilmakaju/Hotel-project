package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import myLibs.JDBCBooking;
import myLibs.JDBCcheckin;
import myLibs.bookinglibs3;

public class checkinform {

	JFrame frame;
	JTextField bookingidtxt, roomnotxt;
	JDateChooser checkintxt;
	JButton updatebtn;
	JComboBox bookingstatustxt;
	Object[] columnsName;
	JTable table;
	DefaultTableModel model;
	ArrayList<bookinglibs3> a1;

//default constructor to set the contents of frame
	public checkinform() {

		frame = new JFrame("Check in ");
		frame.setSize(950, 550);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());

		// initialize and memory allocation

		// +++++++++++++++++North Panel+++++++++++++++=
		JPanel northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setPreferredSize(new Dimension(100, 90));
		northPanel.setBackground(new Color(85, 168, 235));
		frame.add(northPanel, BorderLayout.NORTH);

		JLabel title = new JLabel("Check-In Form");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setBounds(350, 30, 350, 30);
		northPanel.add(title);

		// +++++++++++++++West Panel+++++++++++++++
		JPanel westPanel = new JPanel();
		westPanel.setLayout(null);
		westPanel.setPreferredSize(new Dimension(400, 90));
		westPanel.setBackground(new Color(105, 105, 105));
		frame.add(westPanel, BorderLayout.WEST);

		JPanel customerPanel = new JPanel();
		customerPanel.setLayout(null);
		customerPanel.setLayout(new BorderLayout());
		customerPanel.setPreferredSize(new Dimension(100, 250));
		customerPanel.setBackground(new Color(105, 107, 108));
		frame.add(customerPanel, BorderLayout.CENTER);

		JLabel Bookingidlbl = new JLabel("Booking ID:");
		Bookingidlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		Bookingidlbl.setBounds(10, 20, 150, 30);
		westPanel.add(Bookingidlbl);

		bookingidtxt = new JTextField();
		bookingidtxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bookingidtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		bookingidtxt.setBounds(150, 20, 200, 30);
		westPanel.add(bookingidtxt);

		JLabel arrivelbl = new JLabel("Arrival Date:");
		arrivelbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		arrivelbl.setBounds(10, 90, 150, 30);
		westPanel.add(arrivelbl);

		checkintxt = new JDateChooser();
		checkintxt.setDateFormatString("yyyy-MM-dd");
		checkintxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		checkintxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		checkintxt.setBounds(150, 90, 200, 30);
		westPanel.add(checkintxt);

		JLabel bookingtypelbl = new JLabel("Booking Type:");
		bookingtypelbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		bookingtypelbl.setBounds(10, 150, 150, 30);
		westPanel.add(bookingtypelbl);

		Object[] h1 = { "Active" };
		bookingstatustxt = new JComboBox(h1);
		bookingstatustxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bookingstatustxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		bookingstatustxt.setBounds(150, 150, 200, 30);
		westPanel.add(bookingstatustxt);

		JLabel roomlbl = new JLabel("Room no:");
		roomlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		roomlbl.setBounds(10, 210, 150, 30);
		westPanel.add(roomlbl);

		roomnotxt = new JTextField();
		roomnotxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		roomnotxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		roomnotxt.setBounds(150, 210, 200, 30);
		westPanel.add(roomnotxt);

		updatebtn = new JButton("Check In");
		updatebtn.setBackground(new Color(126, 118, 118));
		updatebtn.setFocusable(false);
		updatebtn.setForeground(Color.white);
		updatebtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		updatebtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		updatebtn.setBounds(150, 270, 100, 30);
		westPanel.add(updatebtn);
		updatebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String status = bookingstatustxt.getSelectedItem().toString();

				bookinglibs3 book = new bookinglibs3();
				book.setBookingstatus(status);
				book.setBookingid(Integer.parseInt(bookingidtxt.getText()));

				JDBCcheckin jdbc = new JDBCcheckin();
				boolean result = jdbc.update(book);

				if (result == true) {
					updateTable();
					JOptionPane.showMessageDialog(null, "customer checkin sucessfully");
				} else {
					JOptionPane.showMessageDialog(null, "Error!");

				}

			}

		});

		// JTable to add in frame

		// ****************Customer Booking Table**************
		columnsName = new Object[4];
		columnsName[0] = "Booking ID";
		columnsName[1] = "ArrivalDate";
		columnsName[2] = "Booking status";
		columnsName[3] = "Room no";

		table = new JTable();
		
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);

		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setBounds(400, 20, 500, 400);
		customerPanel.add(scroll1, BorderLayout.CENTER);
		table.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					int h6 = table.getSelectedRow();

					TableModel modle15 = table.getModel();

					String id = modle15.getValueAt(h6, 0).toString();
					bookingidtxt.setText(id);

					Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) modle15.getValueAt(h6, 1));
					checkintxt.setDate(date);

					String status = modle15.getValueAt(h6, 2).toString();
					bookingstatustxt.setToolTipText(status);

					String room = modle15.getValueAt(h6, 3).toString();
					roomnotxt.setText(id);

				} catch (Exception ex) {
					System.out.println("Error" + ex.getMessage());
				}

			}

		});

		updateTable();
		frame.setVisible(true);

	}

	public void updateTable() {
		JDBCBooking jdbc = new JDBCBooking();
		ArrayList select = jdbc.select_all();
		model.setRowCount(0);
		if (select.size() > 0) {
			for (int i = 0; i < select.size(); i++) {

				bookinglibs3 bookingLibs = (bookinglibs3) select.get(i);
				Vector tmpperson = new Vector();

				tmpperson.add(bookingLibs.getBookingid());
				tmpperson.add(bookingLibs.getArrivaldate());
				tmpperson.add(bookingLibs.getBookingstatus());
				tmpperson.add(bookingLibs.getRoomno());

				model.addRow(tmpperson);
			}
		}

	}

	public static void main(String[] args) {
		new checkinform();

	}

}
