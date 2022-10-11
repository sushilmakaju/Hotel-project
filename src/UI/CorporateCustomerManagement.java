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

import myLibs.JDBCRegistration;
import myLibs.JDBCRegistration2corp;
import myLibs.RegistrationLibs;

public class CorporateCustomerManagement implements MouseListener{
	JFrame frame;
	JButton logoutbtn;
	JTextField customeridtxt, nametxt, emailtxt, mbltxt, addtxt, usertxt, passtxt, Acctxt, cvctxt;
	JButton insertbtn, updatebtn, deletebtn;
	Object[] columnsName;
	JTable table;
	JComboBox roletxt;
	DefaultTableModel model;
	ArrayList<RegistrationLibs> a1;

	//default constructor to set the contents of frame
	public CorporateCustomerManagement() {
		frame = new JFrame("CorporateCustomerManagement");
		frame.setSize(950, 600);
		frame.setExtendedState(frame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout());
		
//initialize and memory allocation
		// +++++++++++++++++North Panel+++++++++++++++=
		JPanel northPanel = new JPanel();
		northPanel.setLayout(null);
		northPanel.setPreferredSize(new Dimension(100, 90));
		northPanel.setBackground(new Color(85, 168, 235));
		frame.add(northPanel, BorderLayout.NORTH);

		JLabel title = new JLabel("CorporateCustomer Management");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Tahoma", Font.BOLD, 30));
		title.setBounds(500, 30, 550, 40);
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

		JLabel customeridlbl = new JLabel("Customer ID:");
		customeridlbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		customeridlbl.setBounds(0, 20, 150, 20);
		westPanel1.add(customeridlbl);

		customeridtxt = new JTextField();
		customeridtxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		customeridtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		customeridtxt.setBounds(150, 20, 200, 20);
		westPanel1.add(customeridtxt);

		JLabel namelbl = new JLabel("Name:");
		namelbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		namelbl.setBounds(10, 60, 150, 20);
		westPanel1.add(namelbl);

		nametxt = new JTextField();
		nametxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nametxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		nametxt.setBounds(150, 60, 200, 20);
		westPanel1.add(nametxt);

		JLabel emaillbl = new JLabel("Email:");
		emaillbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		emaillbl.setBounds(10, 100, 150, 20);
		westPanel1.add(emaillbl);

		emailtxt = new JTextField();
		emailtxt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		emailtxt.setBounds(150, 100, 200, 20);
		westPanel1.add(emailtxt);

		JLabel mobilelbl = new JLabel("Mobile no:");
		mobilelbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		mobilelbl.setBounds(10, 140, 150, 20);
		westPanel1.add(mobilelbl);

		mbltxt = new JTextField();
		mbltxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		mbltxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		mbltxt.setBounds(150, 140, 200, 20);
		westPanel1.add(mbltxt);

		JLabel addresslbl = new JLabel("Address:");
		addresslbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		addresslbl.setBounds(10, 180, 150, 20);
		westPanel1.add(addresslbl);

		addtxt = new JTextField();
		addtxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		addtxt.setBounds(150, 180, 200, 20);
		westPanel1.add(addtxt);

		JLabel userlbl = new JLabel("Username:");
		userlbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		userlbl.setBounds(10, 220, 150, 20);
		westPanel1.add(userlbl);

		usertxt = new JTextField();
		usertxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usertxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		usertxt.setBounds(150, 220, 200, 20);
		westPanel1.add(usertxt);

		JLabel passlbl = new JLabel("Password:");
		passlbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		passlbl.setBounds(10, 260, 150, 20);
		westPanel1.add(passlbl);

		passtxt = new JTextField();
		passtxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passtxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		passtxt.setBounds(150, 260, 200, 20);
		westPanel1.add(passtxt);

		JLabel rolelbl = new JLabel("Role:");
		rolelbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		rolelbl.setBounds(10, 300, 150, 20);
		westPanel1.add(rolelbl);
		
		Object[]h1= {"Customer","CorporateCustomer"};
		roletxt = new JComboBox(h1);
		roletxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		roletxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		roletxt.setBounds(150, 300, 200, 20);
		westPanel1.add(roletxt);

		JLabel Accountlbl = new JLabel("Account:");
		Accountlbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		Accountlbl.setBounds(10, 340, 150, 20);
		westPanel1.add(Accountlbl);

		Acctxt = new JTextField();
		Acctxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Acctxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		Acctxt.setBounds(150, 340, 200, 20);
		westPanel1.add(Acctxt);

		JLabel cvclbl = new JLabel("CVC:");
		cvclbl.setFont(new Font("Tahoma", Font.BOLD, 15));
		cvclbl.setBounds(10, 380, 150, 20);
		westPanel1.add(cvclbl);

		cvctxt = new JTextField();
		cvctxt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cvctxt.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		cvctxt.setBounds(150, 380, 200, 20);
		westPanel1.add(cvctxt);

		//adding table in frame
		// ****************Customer Booking Table**************
		columnsName = new Object[10];
		columnsName[0] = "Customer ID";
		columnsName[1] = "Name";
		columnsName[2] = "Email";
		columnsName[3] = "Mobile";
		columnsName[4] = "Address";
		columnsName[5] = "Username";
		columnsName[6] = "Password";
		columnsName[7] = "Role";
		columnsName[8] = "Account";
		columnsName[9] = "CVC";

		table = new JTable();
		table.addMouseListener(this);
		model = (DefaultTableModel) table.getModel();
		model.setColumnIdentifiers(columnsName);
		updateTable();
		JScrollPane scroll1 = new JScrollPane(table);
		scroll1.setBounds(400, 20, 500, 400);
		customerPanel.add(scroll1, BorderLayout.CENTER);

		insertbtn = new JButton("Insert");
		insertbtn.setBackground(new Color(105, 105, 105));
		insertbtn.setFocusable(false);
		insertbtn.setForeground(Color.white);
		insertbtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		insertbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		insertbtn.setBounds(10, 420, 100, 30);
		westPanel1.add(insertbtn);
		insertbtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					RegistrationLibs registration = new RegistrationLibs();
	                 
					registration.setName(nametxt.getText());
					registration.setEmail(emailtxt.getText());
					registration.setMobile(mbltxt.getText());
					registration.setAddress(addtxt.getText());
					registration.setUsername(usertxt.getText());
					registration.setPassword(passtxt.getText());
					registration.setRole(roletxt.getSelectedItem().toString());
					registration.setAccount(Acctxt.getText());
					registration.setCVC(cvctxt.getText());

					JDBCRegistration2corp jdbc = new JDBCRegistration2corp();
					boolean result = jdbc.insert(registration);
					if (result == true) {
						updateTable();
						JOptionPane.showMessageDialog(null, "The data is recorded successfully");
					}

					else {
						JOptionPane.showMessageDialog(null, "The data is not recorded");
					}
				}
		});
				
			
	
		

		updatebtn = new JButton("Update");
		updatebtn.setBackground(new Color(105, 105, 105));
		updatebtn.setFocusable(false);
		updatebtn.setForeground(Color.white);
		updatebtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		updatebtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		updatebtn.setBounds(120, 420, 100, 30);
		westPanel1.add(updatebtn);
		updatebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RegistrationLibs registration = new RegistrationLibs();
				
				registration.setID(Integer.parseInt(customeridtxt.getText()));
				registration.setName(nametxt.getText());
				registration.setEmail(emailtxt.getText());
				registration.setMobile(mbltxt.getText());
				registration.setAddress(addtxt.getText());
				registration.setUsername(usertxt.getText());
				registration.setPassword(passtxt.getText());
				registration.setRole(roletxt.getSelectedItem().toString());
				registration.setAccount(Acctxt.getText());
				registration.setCVC(cvctxt.getText());
				
				JDBCRegistration2corp jdbc2 = new JDBCRegistration2corp();
				boolean result = jdbc2.update(registration);
				if (result == true) {
					updateTable();
					JOptionPane.showMessageDialog(null, "The data is updated successfully");
				}

				else {
					JOptionPane.showMessageDialog(null, "Error to update");
				}
			}

			
		});


		deletebtn = new JButton("delete");
		deletebtn.setBackground(new Color(105, 105, 105));
		deletebtn.setFocusable(false);
		deletebtn.setForeground(Color.white);
		deletebtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		deletebtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		deletebtn.setBounds(230, 420, 100, 30);
		westPanel1.add(deletebtn);
		deletebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RegistrationLibs registration = new RegistrationLibs();
				
				int ID = Integer.parseInt(customeridtxt.getText());
				JDBCRegistration2corp res = new JDBCRegistration2corp();
				boolean Result = res.delete(ID);
				if (Result == true) {
					updateTable();
					JOptionPane.showMessageDialog(null, "Deleted");
				} else {
					JOptionPane.showMessageDialog(null, "Error");
				}
			}
				
			
		});
		
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
		JDBCRegistration2corp jdbc = new JDBCRegistration2corp();
		ArrayList select = jdbc.select_all();
		model.setRowCount(0);
		if (select.size() > 0) {
			for (int i = 0; i < select.size(); i++) {
				RegistrationLibs registration = (RegistrationLibs) select.get(i);
				Vector tmpPerson = new Vector();

				tmpPerson.add(registration.getID());
				tmpPerson.add(registration.getName());
				tmpPerson.add(registration.getEmail());
				tmpPerson.add(registration.getMobile());
				tmpPerson.add(registration.getAddress());
				tmpPerson.add(registration.getUsername());
				tmpPerson.add(registration.getPassword());
				tmpPerson.add(registration.getRole());
				tmpPerson.add(registration.getAccount());
				tmpPerson.add(registration.getCVC());

				model.addRow(tmpPerson);
			}

		}

	}
	@Override
	public void mouseClicked(MouseEvent e) {
		
		try {
			
			  int h6=table.getSelectedRow();
				
				TableModel model1=table.getModel();
				
				String name = model1.getValueAt(h6, 1).toString();
				nametxt.setText(name);
				
				String email = model1.getValueAt(h6, 2).toString();
				emailtxt.setText(email);
				
				String mobile = model1.getValueAt(h6, 3).toString();
				mbltxt.setText(mobile);
				
				String address = model1.getValueAt(h6, 4).toString();
				addtxt.setText(address);
				
				
				String user = model1.getValueAt(h6, 5).toString();
				usertxt.setText(user);
				
				String pass = model1.getValueAt(h6, 6).toString();
				passtxt.setText(pass);
				
				String acc = model1.getValueAt(h6, 8).toString();
				Acctxt.setText(acc);
				
				String cvc = model1.getValueAt(h6, 9).toString();
				cvctxt.setText(cvc);
				
		}
		catch(Exception ex) {
			System.out.println("Error"+ex.getMessage());
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

		new CorporateCustomerManagement();

	}
}
