package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import myLibs.JDBCrestaurent;
import myLibs.bookinglibs3;
import myLibs.restaurentlibs;

public class Restaurent {
	JFrame frame;
	JTextField foodidtxt, pricetxt,bookingidtxt;
	JComboBox fooditemtxt;
	JButton insertbtn;
	Object[] columnsName;
	DefaultTableModel model;
	JTable table;
	ArrayList<restaurentlibs> a1;

	// default constructor to set the contents of frame
	public Restaurent() {
		
		frame = new JFrame("Food Services");
		frame.setSize(950, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());

		// +++++++++++++++++North Panel+++++++++++++++=
		JPanel northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setPreferredSize(new Dimension(100, 90));
		northPanel.setBackground(new Color(85, 168, 235));
		frame.add(northPanel, BorderLayout.NORTH);

		JLabel title = new JLabel("Food Services ");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setBounds(350, 30, 380, 40);
		northPanel.add(title);

		// *********************First Panel****************8
		JPanel WestPanel = new JPanel();
		WestPanel.setLayout(null);
		WestPanel.setPreferredSize(new Dimension(500, 90));
		WestPanel.setBackground(new Color(105, 107, 108));
		frame.add(WestPanel, BorderLayout.WEST);

		

		// +++++++++++++++++++Center Panel+++++++++++++++++++++
		JPanel customerPanel = new JPanel();
		customerPanel.setLayout(new BorderLayout());
		customerPanel.setPreferredSize(new Dimension(100, 250));
		customerPanel.setBackground(new Color(105, 107, 108));
		frame.add(customerPanel, BorderLayout.CENTER);

		JLabel foodidlbl = new JLabel("Booking ID:");
		foodidlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		foodidlbl.setBounds(10, 30, 150, 30);
		WestPanel.add(foodidlbl);

		bookingidtxt = new JTextField();
		bookingidtxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		bookingidtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		bookingidtxt.setBounds(150, 30, 200, 30);
		WestPanel.add(bookingidtxt);

		JLabel fooditemlbl = new JLabel("FoodItem:");
		fooditemlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		fooditemlbl.setBounds(10, 90, 150, 30);
		WestPanel.add(fooditemlbl);

		Object[] h1 = { "Breakfast", "Dinner", "Launch" };
		fooditemtxt = new JComboBox(h1);
		fooditemtxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fooditemtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		fooditemtxt.setBounds(150, 90, 200, 30);
		WestPanel.add(fooditemtxt);

		JLabel pricelbl = new JLabel("Price:");
		pricelbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		pricelbl.setBounds(10, 150, 150, 30);
		WestPanel.add(pricelbl);

		pricetxt = new JTextField();
		pricetxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pricetxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		pricetxt.setBounds(150, 150, 200, 30);
		WestPanel.add(pricetxt);

		insertbtn = new JButton("Add");
		insertbtn.setBackground(new Color(105, 105, 105));
		insertbtn.setFocusable(false);
		insertbtn.setForeground(Color.white);
		insertbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		insertbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		insertbtn.setBounds(170, 210, 100, 30);
		WestPanel.add(insertbtn);
		insertbtn.addActionListener(new ActionListener() {
//			this is implementation of polymorphism and
//			we have replaced the code in action performed method
			@Override
			public void actionPerformed(ActionEvent e) {
				
				restaurentlibs res = new restaurentlibs();
				
				int id = Integer.parseInt(bookingidtxt.getText());
				String item = fooditemtxt.getSelectedItem().toString();
				int price = Integer.parseInt(pricetxt.getText());
				
				res.setBookingid(id);
				res.setFooditem(item);
				res.setPrice(price);
				
				JDBCrestaurent jdbc = new JDBCrestaurent();
				boolean result=jdbc.insert(res);
				if(result==true) {
					updateTable();
					JOptionPane.showMessageDialog(null, "Food Added Sucessfully");
				}

				else {
					JOptionPane.showMessageDialog(null, "Food is not Added");
				}
			}
				
			
			
		});
		
//adding table in JFrame
		// ****************Customer Booking Table**************
		columnsName = new Object[4];
		columnsName[0] = "Food ID";
		columnsName[1] = "Food Items";
		columnsName[2] = "Price";
		columnsName[3] = "Booking ID";

		table = new JTable();
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);
		
		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setBounds(400, 20, 500, 400);
		customerPanel.add(scroll1, BorderLayout.CENTER);

		updateTable();
		frame.setVisible(true);

	}

	public void updateTable() {
		a1 = new JDBCrestaurent().select_all();
		model.setRowCount(0);

		for (restaurentlibs restaurent : a1) {
			Object tmpRow[] = { restaurent.getFoodid(), 
					restaurent.getFooditem(), 
					restaurent.getPrice(),
					restaurent.getBookingid()
			};
			model.addRow(tmpRow);
		}
		table = new JTable(model);
		
	}

//main method to run the program
	public static void main(String[] args) {
		new Restaurent();

	}

}