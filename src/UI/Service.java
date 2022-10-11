package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
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

import myLibs.JDBCservice;
import myLibs.ServiceLibs;

public class Service {
	JFrame frame;
	JTextField bookingidtxt, pricetxt;
	JComboBox serviceitemtxt;
	JButton insertbtn;
	Object[] columnsName;
	DefaultTableModel model;
	JTable table;
	ArrayList<ServiceLibs> a1;

	
	public Service() {
		// default constructor to set the contents of frame
		frame = new JFrame("Bar Services");
		frame.setSize(950, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		
		//initialize and memory allocation
		// +++++++++++++++++North Panel+++++++++++++++
		JPanel northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setPreferredSize(new Dimension(100, 90));
		northPanel.setBackground(new Color(85, 168, 235));
		frame.add(northPanel, BorderLayout.NORTH);

		JLabel title = new JLabel("Extra Services ");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setBounds(350, 30, 380, 40);
		northPanel.add(title);

		// *********************First Panel****************
		JPanel WestPanel = new JPanel();
		WestPanel.setLayout(null);
		WestPanel.setPreferredSize(new Dimension(500, 90));
		WestPanel.setBackground(new Color(105, 107, 108));
		frame.add(WestPanel, BorderLayout.WEST);

		// +++++++++++++++++++West 1 Panel+++++++++++++++++++++
		JPanel westPanel1 = new JPanel();
		westPanel1.setLayout(null);
		westPanel1.setBounds(20, 20, 450, 600);
		westPanel1.setBackground(new Color(255, 255, 255, 100));
		WestPanel.add(westPanel1);

		// +++++++++++++++++++Center Panel+++++++++++++++++++++
		JPanel customerPanel = new JPanel();
		customerPanel.setLayout(new BorderLayout());
		customerPanel.setPreferredSize(new Dimension(100, 250));
		customerPanel.setBackground(new Color(105, 107, 108));
		frame.add(customerPanel, BorderLayout.CENTER);

		JLabel foodidlbl = new JLabel("Booking ID:");
		foodidlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		foodidlbl.setBounds(10, 30, 150, 30);
		westPanel1.add(foodidlbl);

		bookingidtxt = new JTextField();
		bookingidtxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bookingidtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		bookingidtxt.setBounds(150, 30, 200, 30);
		westPanel1.add(bookingidtxt);

		JLabel serviceitemlbl = new JLabel("Service Item:");
		serviceitemlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		serviceitemlbl.setBounds(10, 90, 150, 30);
		westPanel1.add(serviceitemlbl);

		Object[] h1 = { "Laundray", "Swimming", "Gym", " Games", "sauna", " Massage" };
		serviceitemtxt = new JComboBox(h1);
		serviceitemtxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		serviceitemtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		serviceitemtxt.setBounds(150, 90, 200, 30);
		westPanel1.add(serviceitemtxt);

		JLabel pricelbl = new JLabel("Price:");
		pricelbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		pricelbl.setBounds(10, 150, 150, 30);
		westPanel1.add(pricelbl);

		pricetxt = new JTextField();
		pricetxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pricetxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		pricetxt.setBounds(150, 150, 200, 30);
		westPanel1.add(pricetxt);

		insertbtn = new JButton("Add");
		insertbtn.setBackground(new Color(105, 105, 105));
		insertbtn.setFocusable(false);
		insertbtn.setForeground(Color.white);
		insertbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		insertbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		insertbtn.setBounds(170, 210, 100, 30);
		westPanel1.add(insertbtn);
		insertbtn.addActionListener(new ActionListener() {
//			this is implementation of polymorphism and
//			we have replaced the code in action performed method
			@Override
			public void actionPerformed(ActionEvent e) {

				ServiceLibs res = new ServiceLibs();

				String item = serviceitemtxt.getSelectedItem().toString();
				int price = Integer.parseInt(pricetxt.getText());
				int bookingid = Integer.parseInt(bookingidtxt.getText());

				res.setBookingid(bookingid);
				res.setServicetype(item);
				res.setServiceprice(price);

				JDBCservice jdbc = new JDBCservice();
				boolean result = jdbc.insert(res);
				if (result == true) {
					updateTable();
					JOptionPane.showMessageDialog(null, "service Added Sucessfully");
				}

				else {
					JOptionPane.showMessageDialog(null, "service is not Added");
				}
			}

		});

		//adding table and scrollpane in frame
		// ****************Customer Booking Table**************
		columnsName = new Object[3];
		columnsName[0] = "Booking ID";
		columnsName[1] = "service Type";
		columnsName[2] = "price";

		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);

		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setBounds(400, 20, 500, 400);
		customerPanel.add(scroll1, BorderLayout.CENTER);

		updateTable();
		frame.setVisible(true);

	}

	// Subclass and to get value at table
	public void updateTable() {
		JDBCservice jdbc = new JDBCservice();
		ArrayList select = jdbc.select_all();

		model.setRowCount(0);
		if (select.size() > 0) {
			for (int i = 0; i < select.size(); i++) {
				ServiceLibs service = (ServiceLibs) select.get(i);
				Vector tmpperson = new Vector();

				tmpperson.add(service.getBookingid());
				tmpperson.add(service.getServicetype());
				tmpperson.add(service.getServiceprice());

				model.addRow(tmpperson);
			}
		}

	}

	//main method to run the program
	public static void main(String[] args) {
		new Service();

	}



}