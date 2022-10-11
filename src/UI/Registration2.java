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

public class Registration2 implements ActionListener, ItemListener{

	JFrame frame;
	JTextField CusID, CusName, CusEmail, CusMobile, CusAddress, CusUsername, CusPassword, CusAccount, CusCVC;

	JTextField ManID, ManName, ManEmail, ManMobile, ManAddress, ManUsername;

	JComboBox CusRole, ManRole;
	JButton registerbtn, registerbtn1, btnback, btnback2;
	JPasswordField ManPassword;
	
	JLabel CusAccountlbl,CusCVClbl;

	/**
	 * Create the frame.
	 */
	//default constructor to set the contents of JFrame
	public Registration2() {
		frame = new JFrame("Registration");
		frame.setSize(1000, 600);
		frame.setLocationRelativeTo(null);
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


		JPanel managerPnl = new JPanel();
		managerPnl.setLayout(null);
		tab.add("Staff", managerPnl);

		JPanel HeadingPanel1 = new JPanel();
		HeadingPanel1.setBounds(0, 0, 700, 50);
		HeadingPanel1.setLayout(null);
		HeadingPanel1.setBackground(new Color(106, 101, 101));
		managerPnl.add(HeadingPanel1);

		JLabel titlelbl1 = new JLabel("Staff Registration", JLabel.CENTER);
		titlelbl1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		titlelbl1.setBounds(100, 10, 450, 35);
		titlelbl1.setForeground(Color.white);
		HeadingPanel1.add(titlelbl1);

		JLabel idlbl1 = new JLabel("ID:");
		idlbl1.setBounds(20, 60, 150, 35);
		idlbl1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(idlbl1);

		ManID = new JTextField();
		ManID.setEditable(false);
		ManID.setBounds(100, 60, 150, 30);
		ManID.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		ManID.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(ManID);

		JLabel CusNamelbl1 = new JLabel("Name:");
		CusNamelbl1.setBounds(20, 110, 150, 35);
		CusNamelbl1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(CusNamelbl1);

		ManName = new JTextField();
		ManName.setBounds(100, 110, 150, 30);
		ManName.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		ManName.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(ManName);

		JLabel CusEmaillbl1 = new JLabel("Email:");
		CusEmaillbl1.setBounds(20, 160, 150, 35);
		CusEmaillbl1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(CusEmaillbl1);

		ManEmail = new JTextField();
		ManEmail.setBounds(100, 160, 150, 30);
		ManEmail.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		ManEmail.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(ManEmail);

		JLabel CusMobilelbl1 = new JLabel("Mobile:");
		CusMobilelbl1.setBounds(20, 210, 150, 35);
		CusMobilelbl1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(CusMobilelbl1);

		ManMobile = new JTextField();
		ManMobile.setBounds(100, 210, 150, 30);
		ManMobile.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		ManMobile.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(ManMobile);

		JLabel CusAddresslbl1 = new JLabel("Address:");
		CusAddresslbl1.setBounds(20, 260, 150, 35);
		CusAddresslbl1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(CusAddresslbl1);

		ManAddress = new JTextField();
		ManAddress.setBounds(100, 260, 150, 30);
		ManAddress.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		ManAddress.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(ManAddress);

		JLabel CusUsernamelbl1 = new JLabel("Username:");
		CusUsernamelbl1.setBounds(20, 310, 150, 35);
		CusUsernamelbl1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(CusUsernamelbl1);

		ManUsername = new JTextField();
		ManUsername.setBounds(100, 310, 150, 30);
		ManUsername.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		ManUsername.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(ManUsername);

		JLabel CusPasswordlbl1 = new JLabel("Password:");
		CusPasswordlbl1.setBounds(300, 60, 150, 35);
		CusPasswordlbl1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(CusPasswordlbl1);

		ManPassword = new JPasswordField();
		ManPassword.setBounds(390, 60, 150, 30);
		ManPassword.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		ManPassword.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(ManPassword);

		JLabel CusRolelbl1 = new JLabel("Role:");
		CusRolelbl1.setBounds(300, 110, 150, 35);
		CusRolelbl1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(CusRolelbl1);

		Object[] H2 = { "Staff", "Receptionist" };
		ManRole = new JComboBox(H2);
		ManRole.setBounds(390, 110, 150, 30);
		ManRole.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		ManRole.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(ManRole);

		registerbtn1 = new JButton("Register");
		registerbtn1.addActionListener(this);
		registerbtn1.setForeground(Color.white);
		registerbtn1.setBackground(new Color(106, 101, 101));
		registerbtn1.setBounds(50, 380, 100, 30);
		registerbtn1.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		registerbtn1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(registerbtn1);
		
		btnback2 = new JButton("Back to login");
		btnback2.addActionListener(this);
		btnback2.setForeground(Color.white);
		btnback2.setBackground(new Color(106, 101, 101));
		btnback2.setBounds(200, 380, 100, 30);
		btnback2.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btnback2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		managerPnl.add(btnback2);
		
		

		frame.setVisible(true);
	}
//	this is implementation of polymorphism and
//	we have replaced the code in action performed method

	@Override
	public void actionPerformed(ActionEvent e) {
		
            if (e.getSource() == registerbtn1) {

			RegistrationLibs registration = new RegistrationLibs();

			registration.setName(ManName.getText());
			registration.setEmail(ManEmail.getText());
			registration.setMobile(ManMobile.getText());
			registration.setAddress(ManAddress.getText());
			registration.setUsername(ManUsername.getText());
			registration.setPassword(ManPassword.getText());
			registration.setRole(ManRole.getSelectedItem().toString());

			JDBCRegistration jdbc = new JDBCRegistration();
			boolean result = jdbc.insert(registration);
			if (result == true) {
				JOptionPane.showMessageDialog(null, "The data is recorded successfully");
			}

			else {
				JOptionPane.showMessageDialog(null, "The data is not recorded");
			}

		} else if (e.getSource() == btnback2) {

			login log = new login();
			frame.setVisible(false);
		}

	}
//main method to run the program
	public static void main(String[] args) {
		new Registration2();
	}
//	this is implementation of polymorphism and
//	we have replaced the code in itemStateChanged performed method
	@Override
	public void itemStateChanged(ItemEvent ie) {
		if(ie.getSource()==ManRole) {
			String strRole = ManRole.getSelectedItem().toString();

		}				
	}

}
