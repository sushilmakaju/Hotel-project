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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.toedter.calendar.JDateChooser;

import myLibs.BillingLibs;
import myLibs.BillingLibs2;
import myLibs.Global;
import myLibs.JDBCBilling;
import myLibs.JDBCroom;
import myLibs.bookinglibs3;
import myLibs.roomLibs;


public class Billing implements MouseListener {
	JFrame frame;
	JButton logoutbtn;
	JTextField searchField;
	TableRowSorter sorter;
	JTable table1;
	JTextField bookingidtxt, customeridtxt, nametxt, typetxt, roomratetxt, servicepricetxt, foodpricetxt, vattxt,
			servicechargetxt, totalbilltxt, totalpaidtxt, returnamounttxt, drinktxt, roomidtxt, noofdaystxt,
			roompricetxt, discounttxt;
	JComboBox statustxt, billingstatustxt;
	JButton generatebillbtn, calculatebillbtn;
	Object[] Col;
	DefaultTableModel model;
	ArrayList<BillingLibs> Billing;
	JDateChooser date1, date2;
	
	//default constructor to set the contents of frame
	public Billing() {
		frame = new JFrame("Check Out");
		frame.setSize(1450, 800);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new BorderLayout());
		
//initialize and memory allocation
		// ***************North Panel*****************
		JPanel north = new JPanel();
		north.setLayout(null);
		north.setBackground(new Color(85, 168, 235));
		north.setPreferredSize(new Dimension(100, 100));
		frame.add(north, BorderLayout.NORTH);

		bookingidtxt = new JTextField();

		
		

		
		JLabel searchlbl = new JLabel("Search: ");
		searchlbl.setBounds(970, 30, 210, 30);
		searchlbl.setForeground(Color.white);
		searchlbl.setFont(new Font("Verdana", Font.BOLD, 18));
		north.add(searchlbl);

		
		searchField = new JTextField();
		searchField.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		searchField.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		searchField.setBounds(1050, 30, 200, 30);
		north.add(searchField);

		searchField.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				search(searchField.getText());
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				search(searchField.getText());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				search(searchField.getText());
			}

			public void search(String str) {
				if (str.length() == 0) {
					sorter.setRowFilter(null);
				} else {
					sorter.setRowFilter(RowFilter.regexFilter(str));
				}
			}
		});
		
//adding table in JFrame
		// **********************Center Panel*****************
		Col = new Object[9];
		Col[0] = "Booking ID";
		Col[1] = "Arrival Date";
		Col[2] = "Departure Date";
		Col[3] = "Name";
		Col[4] = "Room No";
		Col[5] = "Room Price";
		Col[6] = "Food Price";
		Col[7] = "Bar Price";
		Col[8] = "Service Price";
		table1 = new JTable();
		model = (DefaultTableModel) table1.getModel();
		model.setColumnIdentifiers(Col);
		table1.addMouseListener(this);

		
		JScrollPane scroll1 = new JScrollPane(table1);
		scroll1.setBounds(400, 20, 500, 400);
		frame.add(scroll1, BorderLayout.CENTER);



		// *******************SOUTH Panel******************
		JPanel southPanel = new JPanel();
		southPanel.setLayout(null);
		southPanel.setPreferredSize(new Dimension(400, 280));
		frame.add(southPanel, BorderLayout.SOUTH);

		roomidtxt = new JTextField();

		JLabel namelbl = new JLabel("Name:");
		namelbl.setBounds(10, 20, 210, 25);
		namelbl.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(namelbl);

		nametxt = new JTextField();
		nametxt.setBounds(180, 20, 150, 25);
		nametxt.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(nametxt);
		
		JLabel checkinlbl = new JLabel("Arrival Date:");
		checkinlbl.setBounds(10, 70, 210, 25);
		checkinlbl.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(checkinlbl);

		date1 = new JDateChooser();
		date1.setDateFormatString("yyyy-MM-dd");
		date1.setBounds(180, 70, 150, 25);
		date1.setFont(new Font("Verdana", Font.PLAIN, 15));
		southPanel.add(date1);

		JLabel checkoutlbl = new JLabel("Departure Date: ");
		checkoutlbl.setBounds(10, 120, 210, 25);
		checkoutlbl.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(checkoutlbl);

		date2 = new JDateChooser();
		date2.setDateFormatString("yyyy-MM-dd");
		date2.setBounds(180, 120, 150, 25);
		date2.setFont(new Font("Verdana", Font.PLAIN, 15));
		southPanel.add(date2);
		
		JLabel noofdays = new JLabel("No of Days: ");
		noofdays.setBounds(10, 170, 210, 25);
		noofdays.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(noofdays);

		noofdaystxt = new JTextField();
		noofdaystxt.setBounds(180, 170, 150, 25);
		noofdaystxt.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(noofdaystxt);

		JLabel roompricelbl = new JLabel("Room Rate:");
		roompricelbl.setBounds(10, 220, 210, 25);
		roompricelbl.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(roompricelbl);

		roomratetxt = new JTextField();
		roomratetxt.setBounds(180, 220, 150, 25);
		roomratetxt.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(roomratetxt);

		JLabel roomlbl = new JLabel("Drink Amount:");
		roomlbl.setBounds(10, 270, 210, 25);
		roomlbl.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(roomlbl);

		drinktxt = new JTextField();
		drinktxt.setBounds(180, 270, 150, 25);
		drinktxt.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(drinktxt);

		
		JLabel servicepricelbl = new JLabel("Service Amount:");
		servicepricelbl.setBounds(380, 20, 200, 25);
		servicepricelbl.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(servicepricelbl);

		servicepricetxt = new JTextField();
		servicepricetxt.setBounds(550, 20, 150, 25);
		servicepricetxt.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(servicepricetxt);

		JLabel foodpricelbl = new JLabel("Food Price:");
		foodpricelbl.setBounds(380, 70, 210, 25);
		foodpricelbl.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(foodpricelbl);

		foodpricetxt = new JTextField();
		foodpricetxt.setBounds(550, 70, 150, 25);
		foodpricetxt.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(foodpricetxt);
		
		JLabel roompricelbl1 = new JLabel("Room Price:");
		roompricelbl1.setBounds(380, 120, 210, 25);
		roompricelbl1.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(roompricelbl1);

		roompricetxt = new JTextField();
		roompricetxt.setBounds(550, 120, 150, 25);
		roompricetxt.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(roompricetxt);

		JLabel vatlbl = new JLabel("VAT:");
		vatlbl.setBounds(380, 170, 210, 25);
		vatlbl.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(vatlbl);

		vattxt = new JTextField();
		vattxt.setText("13%");
		vattxt.setEditable(false);
		vattxt.setBounds(550, 170, 150, 25);
		vattxt.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(vattxt);

		JLabel servicechargelbl = new JLabel("Service Charge: ");
		servicechargelbl.setBounds(380, 220, 210, 25);
		servicechargelbl.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(servicechargelbl);

		servicechargetxt = new JTextField();
		servicechargetxt.setText("Rs: 100");
		servicechargetxt.setEditable(false);
		servicechargetxt.setBounds(550, 220, 150, 25);
		servicechargetxt.setFont(new Font("Verdana", Font.BOLD, 18));
		southPanel.add(servicechargetxt);
		
		JLabel discountlbl = new JLabel("Discount:");
		discountlbl.setBounds(780, 20, 210, 25);
		discountlbl.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(discountlbl);

		discounttxt = new JTextField();
		discounttxt.setBounds(950, 20, 150, 25);
		discounttxt.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(discounttxt);

		JLabel totalbilllbl = new JLabel("Total Amount: ");
		totalbilllbl.setBounds(780, 70, 210, 25);
		totalbilllbl.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(totalbilllbl);

		totalbilltxt = new JTextField();
		totalbilltxt.setBounds(950, 70, 150, 25);
		totalbilltxt.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(totalbilltxt);


		JLabel totalpaidlbl = new JLabel("Total Paid: ");
		totalpaidlbl.setBounds(780, 120, 210, 25);
		totalpaidlbl.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(totalpaidlbl);

		totalpaidtxt = new JTextField();
		totalpaidtxt.setBounds(950, 120, 150, 25);
		totalpaidtxt.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(totalpaidtxt);
		totalpaidtxt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				float bill1;

				int pay1 = Integer.parseInt(totalpaidtxt.getText());
				bill1 = Float.parseFloat(totalbilltxt.getText());

				float result = pay1 - bill1;
				returnamounttxt.setText(Float.toString(result));
			}

		});

		JLabel returnamountlbl = new JLabel("Return Amount: ");
		returnamountlbl.setBounds(780, 170, 210, 25);
		returnamountlbl.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(returnamountlbl);

		returnamounttxt = new JTextField();
		returnamounttxt.setBounds(950, 170, 150, 25);
		returnamounttxt.setFont(new Font("Verdana", Font.BOLD, 18));
		southPanel.add(returnamounttxt);

		JLabel billingststaus = new JLabel("Billing Status: ");
		billingststaus.setBounds(780, 220, 210, 25);
		billingststaus.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(billingststaus);

		Object[] h55 = { "Paid", "Unpaid"};
		billingstatustxt = new JComboBox(h55);
		billingstatustxt.setBounds(950, 220, 150, 25);
		billingstatustxt.setFont(new Font("Verdana", Font.BOLD, 15));
		southPanel.add(billingstatustxt);


		generatebillbtn = new JButton("Pay");
		generatebillbtn.setFocusable(false);
		generatebillbtn.setBounds(1150, 70, 90, 25);
		generatebillbtn.setFont(new Font("Verdana", Font.BOLD, 18));
		generatebillbtn.setForeground(Color.white);
		generatebillbtn.setBackground(new Color(106, 101, 101));
		southPanel.add(generatebillbtn);
		generatebillbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == generatebillbtn) {

					roomLibs room = new roomLibs();

					int room_id = Integer.parseInt(roomidtxt.getText());

   				room.setRoom_no(room_id);
					room.setRoom_status("Available");

				JDBCroom jdbc1 = new JDBCroom();
					boolean result2 = jdbc1.receptionupdate(room);

					// *******************Update Booking Status**************
					bookinglibs3 booking = new bookinglibs3();
					booking.setBookingid(Integer.parseInt(bookingidtxt.getText()));
					booking.setBookingstatus("Inactive");
					JDBCBilling jdbc5 = new JDBCBilling();
					boolean result5 = jdbc5.update(booking);

					// ++++++++++++++++Blling********************8
				BillingLibs2 billing = new BillingLibs2();
				
				
					
					billing.setName(nametxt.getText());
					billing.setDrink_Amount(Integer.parseInt(drinktxt.getText()));
					billing.setService_Amount(Integer.parseInt(servicepricetxt.getText()));
					billing.setFood_Amount(Integer.parseInt(foodpricetxt.getText()));
					billing.setRoom_Amount(Integer.parseInt(roompricetxt.getText()));
					billing.setTotal_Bill(Double.parseDouble(totalbilltxt.getText()));
					billing.setTotal_Paid(Double.parseDouble(totalpaidtxt.getText()));
					billing.setReturn_Amount(Double.parseDouble(returnamounttxt.getText()));
					billing.setDiscount(Double.parseDouble(discounttxt.getText()));
					billing.setBilling_Status(billingstatustxt.getSelectedItem().toString());
					
                    Global.currentBilling=billing;
					JDBCBilling jdbc = new JDBCBilling();
					boolean result = jdbc.insertbilling(billing);
					if(result==true) {
						updateTable();
						JOptionPane.showMessageDialog(null, "You have paid successfully!");
					}
					else {
						JOptionPane.showMessageDialog(null, "Error");
					}
					
              new Bill();
				}

				
				
			}
		});

		JButton clearbtn = new JButton("Clear");
		clearbtn.setFocusable(false);
		clearbtn.setBounds(1150, 120, 90, 25);
		clearbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		clearbtn.setFont(new Font("Verdana", Font.BOLD, 18));
		clearbtn.setForeground(Color.white);
		clearbtn.setBackground(new Color(106, 101, 101));
		southPanel.add(clearbtn);
		clearbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				discounttxt.setText(null);
				nametxt.setText(null);
				noofdaystxt.setText(null);
				foodpricetxt.setText(null);
				drinktxt.setText(null);
				roomratetxt.setText(null);
				roompricetxt.setText(null);
				servicepricetxt.setText(null);
				foodpricetxt.setText(null);
				totalbilltxt.setText(null);
				totalpaidtxt.setText(null);
				returnamounttxt.setText(null);

			}

		});
		
		logoutbtn = new JButton("Logout");
		logoutbtn.setBackground(new Color(255, 255, 255, 100));
		logoutbtn.setOpaque(true);
		logoutbtn.setFocusable(false);
		logoutbtn.setForeground(Color.WHITE);
		logoutbtn.setFont(new Font("Tahoma", Font.BOLD, 20));
		logoutbtn.setBounds(20, 30, 120, 30);
		north.add(logoutbtn);
		logoutbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new login();
				
			}

		});
		updateTable();

		frame.setVisible(true);

	}

	public void updateTable() {
	
		JDBCBilling jdbc2 = new JDBCBilling();
		ArrayList select = jdbc2.billing();
		model.setRowCount(0);
		if (select.size()>0) {
		
			for (int i = 0; i < select.size(); i++) {
				
				BillingLibs billing = (BillingLibs) select.get(i);
			    
				Vector tmpPerson = new Vector();
		
		
			tmpPerson.add(billing.getB_Id());
			tmpPerson.add(billing.getArrivalDate()); 
			tmpPerson.add(billing.getDepartureDate());
			tmpPerson.add(billing.getName());
			tmpPerson.add(billing.getRoom_No()); 
			tmpPerson.add(billing.getRoom_Price()); 
			tmpPerson.add(billing.getRes_Price());
			tmpPerson.add(billing.getBar_Price());
			tmpPerson.add(billing.getService_Charge());

			model.addRow(tmpPerson);
		}
	}
		

}
//	this is implementation of polymorphism and
//	we have replaced the code in mouse clicked method
	@Override
	public void mouseClicked(MouseEvent e) {

		try {

			int h1 = table1.getSelectedRow();

			TableModel model1 = table1.getModel();
			
			String roomid = model1.getValueAt(h1, 6).toString();
			roomidtxt.setText(roomid);
			
			String bookingid = model1.getValueAt(h1, 0).toString();
			bookingidtxt.setText(bookingid);

			String name = model1.getValueAt(h1, 3).toString();
			nametxt.setText(name);

			
			String drinkamount = model1.getValueAt(h1, 7).toString();
			drinktxt.setText(drinkamount);


			Date date = new SimpleDateFormat("yyyy-MM-dd").parse((String) model1.getValueAt(h1, 1));
			date1.setDate(date);

			Date date3 = new SimpleDateFormat("yyyy-MM-dd").parse((String) model1.getValueAt(h1, 2));
			date2.setDate(date3);

			String roomprice = model1.getValueAt(h1, 5).toString();
			roomratetxt.setText(roomprice);

			String serviceprice = model.getValueAt(h1, 8).toString();
			servicepricetxt.setText(serviceprice);

			String foodprice = model1.getValueAt(h1, 6).toString();
			foodpricetxt.setText(foodprice);

			String fromdate = ((JTextField) date1.getDateEditor().getUiComponent()).getText();
			String todate = ((JTextField) date2.getDateEditor().getUiComponent()).getText();

			LocalDate fday = LocalDate.parse(fromdate);
			LocalDate tday = LocalDate.parse(todate);

			Long day_gap = ChronoUnit.DAYS.between(fday, tday);
			noofdaystxt.setText(String.valueOf(day_gap));

			int rate = Integer.parseInt(roomratetxt.getText());
			int days = Integer.parseInt(noofdaystxt.getText());
			int result = rate * days;
			roompricetxt.setText(String.valueOf(result));

			float roomprice1;
			float serviceprice1;
			float foodprice1;
			float drinkprice1;

			drinkprice1 = Integer.parseInt(drinktxt.getText());
			roomprice1 = Integer.parseInt(roompricetxt.getText());
			serviceprice1 = Integer.parseInt(servicepricetxt.getText());
			foodprice1 = Integer.parseInt(foodpricetxt.getText());

			float h5 = roomprice1 + serviceprice1 + foodprice1 + drinkprice1;

			float h6 = (float) 0.13;
			float h7 = h6 * h5;

			float h8 = h7 + h5 + 100;

			float discount = h8 * h6;

			float h9 = h8 - discount;

			discounttxt.setText(Float.toString(discount));

			totalbilltxt.setText(Float.toString(h9));

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
		new Billing();
	}

}

