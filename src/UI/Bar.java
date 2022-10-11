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

import myLibs.JDBCbar;
import myLibs.JDBCrestaurent;
import myLibs.barlibs;
import myLibs.restaurentlibs;

public class Bar {
	JFrame frame;
	JTextField bookingidtxt, pricetxt;
	JComboBox fooditemtxt;
	JButton insertbtn;
	Object[] columnsName;
	DefaultTableModel model;
	JTable table;
	ArrayList<barlibs> a1;

	public Bar() {
		frame = new JFrame("Bar Services");
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

		JLabel title = new JLabel("Bar Services ");
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

		JLabel fooditemlbl = new JLabel("Bar Item:");
		fooditemlbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		fooditemlbl.setBounds(10, 90, 150, 30);
		westPanel1.add(fooditemlbl);

		Object[] h1 = { "SoftDrinks", "ColdDrinks", "HardDrinks" };
		fooditemtxt = new JComboBox(h1);
		fooditemtxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		fooditemtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		fooditemtxt.setBounds(150, 90, 200, 30);
		westPanel1.add(fooditemtxt);

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

			@Override
			public void actionPerformed(ActionEvent e) {
				
				barlibs res = new barlibs();
				
				int bookingid = Integer.parseInt(bookingidtxt.getText());
				String item = fooditemtxt.getSelectedItem().toString();
				int price = Integer.parseInt(pricetxt.getText());
			
				
				res.setBookingid(bookingid);
				res.setBaritem(item);
				res.setPrice(price);
				
				
				JDBCbar jdbc = new JDBCbar();
				boolean result=jdbc.insert(res);
				if(result==true) {
					updateTable();
					JOptionPane.showMessageDialog(null, "Bar Added Sucessfully");
				}

				else {
					JOptionPane.showMessageDialog(null, "Bar is not Added");
				}
			}
				
			
			
		});
		

		// ****************Customer Booking Table**************
		columnsName = new Object[3];
		columnsName[0] = "Booking ID";
		columnsName[1] = "Bar item";
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

	public void updateTable() {
		a1 = new JDBCbar().select_all();
		model.setRowCount(0);

		for (barlibs restaurent : a1) {
			Object tmpRow[] = { restaurent.getBar_id(), 
					restaurent.getBaritem(), 
					restaurent.getPrice() 
			};
			model.addRow(tmpRow);
		}
		table = new JTable(model);
		
	}


	public static void main(String[] args) {
		new Bar();

	}

}