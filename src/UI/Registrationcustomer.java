package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import myLibs.JDBCRegistration;
import myLibs.RegistrationLibs;
import myLibs.RegexExpression;

public class Registrationcustomer implements ActionListener, ItemListener {

	JFrame frame;
	JTextField CusID, CusName, CusEmail, CusMobile, CusAddress, CusUsername, CusAccount, CusCVC;

	JComboBox CusRole;
	JButton registerbtn, btnback;
	JPasswordField CusPassword;

	JLabel CusAccountlbl, CusCVClbl;
	
	
//default constructor to set the contents of frame
	public Registrationcustomer() {
		frame = new JFrame("Registration");
		frame.setSize(1000, 600);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());

		//initialize and memory allocation
		JPanel north = new JPanel();
		north.setPreferredSize(new Dimension(100, 60));
		north.setBackground(new Color(106, 101, 101));
		frame.add(north, BorderLayout.NORTH);

		JLabel titlelb = new JLabel("Registration Your Account Here", JLabel.CENTER);
		titlelb.setFont(new Font("Times New Roman", Font.BOLD, 25));
		titlelb.setBounds(180, 15, 250, 35);
		titlelb.setForeground(Color.white);
		north.add(titlelb);

		JLabel lbl = new JLabel();
		lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("Mobile login-rafiki1.png")));
		lbl.setPreferredSize(new Dimension(400, 60));
		frame.add(lbl, BorderLayout.WEST);

		JTabbedPane tab = new JTabbedPane();
		frame.add(tab, BorderLayout.CENTER);

		JPanel customerPnl = new JPanel();
		customerPnl.setLayout(null);
		tab.add("Customer", customerPnl);

		JPanel HeadingPanel = new JPanel();
		HeadingPanel.setBounds(0, 0, 700, 50);
		HeadingPanel.setLayout(null);
		HeadingPanel.setBackground(new Color(106, 101, 101));
		customerPnl.add(HeadingPanel);

		JLabel titlelbl = new JLabel("Customer Registration", JLabel.CENTER);
		titlelbl.setFont(new Font("Times New Roman", Font.BOLD, 25));
		titlelbl.setBounds(180, 10, 250, 35);
		titlelbl.setForeground(Color.white);
		HeadingPanel.add(titlelbl);

		JLabel idlbl = new JLabel("ID:");
		idlbl.setBounds(20, 60, 150, 35);
		idlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(idlbl);

		CusID = new JTextField();
		CusID.setEditable(false);
		CusID.setBounds(100, 60, 150, 30);
		CusID.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		CusID.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(CusID);

		JLabel CusNamelbl = new JLabel("Name:");
		CusNamelbl.setBounds(20, 110, 150, 35);
		CusNamelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(CusNamelbl);

		CusName = new JTextField();
		CusName.setBounds(100, 110, 150, 30);
		CusName.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		CusName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(CusName);

		JLabel CusEmaillbl = new JLabel("Email:");
		CusEmaillbl.setBounds(20, 160, 150, 35);
		CusEmaillbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(CusEmaillbl);

		CusEmail = new JTextField();
		CusEmail.setBounds(100, 160, 150, 30);
		CusEmail.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		CusEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(CusEmail);

		JLabel CusMobilelbl = new JLabel("Mobile:");
		CusMobilelbl.setBounds(20, 210, 150, 35);
		CusMobilelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(CusMobilelbl);

		CusMobile = new JTextField();
		CusMobile.setBounds(100, 210, 150, 30);
		CusMobile.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		CusMobile.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(CusMobile);

		JLabel CusAddresslbl = new JLabel("Address:");
		CusAddresslbl.setBounds(20, 260, 150, 35);
		CusAddresslbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(CusAddresslbl);

		CusAddress = new JTextField();
		CusAddress.setBounds(100, 260, 150, 30);
		CusAddress.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		CusAddress.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(CusAddress);

		JLabel CusUsernamelbl = new JLabel("Username:");
		CusUsernamelbl.setBounds(20, 310, 150, 35);
		CusUsernamelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(CusUsernamelbl);

		CusUsername = new JTextField();
		CusUsername.setBounds(100, 310, 150, 30);
		CusUsername.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		CusUsername.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(CusUsername);

		JLabel CusPasswordlbl = new JLabel("Password:");
		CusPasswordlbl.setBounds(300, 60, 150, 35);
		CusPasswordlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(CusPasswordlbl);

		CusPassword = new JPasswordField();
		CusPassword.setBounds(390, 60, 150, 30);
		CusPassword.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		CusPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(CusPassword);

		JLabel CusRolelbl = new JLabel("Role:");
		CusRolelbl.setBounds(300, 110, 150, 35);
		CusRolelbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(CusRolelbl);

		Object[] H1 = { "Customer", "Corp Customer" };
		CusRole = new JComboBox(H1);
		CusRole.setBounds(390, 110, 150, 30);
		CusRole.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		CusRole.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CusRole.addItemListener(this);
		customerPnl.add(CusRole);

		CusAccountlbl = new JLabel("Account No:");
		CusAccountlbl.setBounds(300, 160, 150, 35);
		CusAccountlbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(CusAccountlbl);
		CusAccountlbl.setVisible(false);

		CusAccount = new JTextField();
		CusAccount.setBounds(390, 160, 150, 30);
		CusAccount.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		CusAccount.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CusAccount.setVisible(false);
		customerPnl.add(CusAccount);

		CusCVClbl = new JLabel("CVC:");
		CusCVClbl.setBounds(300, 210, 150, 35);
		CusCVClbl.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CusCVClbl.setVisible(false);
		customerPnl.add(CusCVClbl);

		CusCVC = new JTextField();
		CusCVC.setBounds(390, 210, 150, 30);
		CusCVC.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		CusCVC.setFont(new Font("Times New Roman", Font.BOLD, 16));
		CusCVC.setVisible(false);
		customerPnl.add(CusCVC);

		registerbtn = new JButton("Register");
		registerbtn.addActionListener(this);
		registerbtn.setForeground(Color.white);
		registerbtn.setBackground(new Color(106, 101, 101));
		registerbtn.setBounds(50, 380, 100, 30);
		registerbtn.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		registerbtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(registerbtn);

		btnback = new JButton("Back to login");
		btnback.addActionListener(this);
		btnback.setForeground(Color.white);
		btnback.setBackground(new Color(106, 101, 101));
		btnback.setBounds(200, 380, 100, 30);
		btnback.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btnback.setFont(new Font("Times New Roman", Font.BOLD, 16));
		customerPnl.add(btnback);

		frame.setVisible(true);
	}

//	this is implementation of polymorphism and
//	we have replaced the code in action performed method
	@Override
	public void actionPerformed(ActionEvent e) {

		RegexExpression val = new RegexExpression();

		if (e.getSource() == registerbtn) {

			 RegistrationLibs registration = new RegistrationLibs();

			String Name = CusName.getText();
			boolean resultname = val.Name(Name);
			if (resultname == true) {

				String number = CusMobile.getText();
				boolean result = val.phone(number);
				if (result == true) {

					String email = CusEmail.getText();
					boolean emailresult = val.Email(email);
					if (emailresult == true) {

						String username = CusUsername.getText();
						boolean resultusername = val.UserName(username);
						if (resultusername == true) {

							String password = CusPassword.getText();
							boolean resultpassword = val.Password(password);
							if (resultpassword == true) {

								String Role = CusRole.getSelectedItem().toString();
								boolean role1 = val.role(Role);
								if (role1 == true) {
											registration.setName(CusName.getText());
											registration.setMobile(CusMobile.getText());
											registration.setEmail(CusEmail.getText());
											registration.setUsername(CusUsername.getText());
											registration.setPassword(CusPassword.getText());
											registration.setRole(CusRole.getSelectedItem().toString());
											registration.setAccount(CusAccount.getText());
											registration.setCVC(CusCVC.getText());
											registration.setAddress(CusAddress.getText());
											JDBCRegistration jdbc = new JDBCRegistration();
											boolean result1 = jdbc.insert(registration);
											if(result1==true) {
												JOptionPane.showMessageDialog(null, "Registered Successfully");
											}else {
												
											}
											
										
								} else {
									JOptionPane.showMessageDialog(null, "Invalid Role");

								}

							} else {
								JOptionPane.showMessageDialog(null, "your password must contain 4 or more than 4 numbers!");
							}

						} else {
							JOptionPane.showMessageDialog(null, "The first letter should be in upper_case and should have a number!");
						}

					} else {
						JOptionPane.showMessageDialog(null, "Invalid Email");
					}

				} else {
					JOptionPane.showMessageDialog(null, "Invalid Mobile Number");
				}

			} else {
				JOptionPane.showMessageDialog(null, "The first letter should be in upper_case ");
			}
		}
			else if (e.getSource() == btnback) {

				login log = new login();
				frame.setVisible(false);
			
			
		}
	}

		


//mainmethod to run the program
	public static void main(String[] args) {
		new Registrationcustomer();
	}

//	this is implementation of polymorphism and
//	we have replaced the code in item performed method
	@Override
	public void itemStateChanged(ItemEvent ie) {
		if (ie.getSource() == CusRole) {
			String strRole = CusRole.getSelectedItem().toString();
			if (strRole.equals("Customer")) {
				CusAccountlbl.setVisible(false);
				CusAccount.setVisible(false);
				CusCVClbl.setVisible(false);
				CusCVC.setVisible(false);
			} else if (strRole.equals("Corp Customer")) {
				CusAccountlbl.setVisible(true);
				CusAccount.setVisible(true);
				CusCVClbl.setVisible(true);
				CusCVC.setVisible(true);
			}
		}
	}

}
