package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import myLibs.Global;
import myLibs.JDBCLogin;
import myLibs.LoginLibs;

public class login extends JFrame implements ActionListener {
	JLabel lblusr, lblpic, lblpass, lbltitle;
	JTextField txtuser;
	JPasswordField pass;
	JPanel panel;
	JButton btnlogin, btnregister, btnclose;

	// default constructor
	public login() {
		setTitle("Login");
		setSize(950, 550);
		setResizable(false);
		setLocationRelativeTo(null);
		setLayout(null);

		// pannel
		panel = new JPanel();
		panel.setBackground(new Color(106, 101, 101));
		panel.setBounds(0, 0, 950, 60);
		panel.setLayout(null);
		add(panel);

		lbltitle = new JLabel("Login To Your Account Here");
		lbltitle.setBounds(350, 15, 400, 35);
		lbltitle.setForeground(Color.white);
		lbltitle.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lbltitle);

		// to set picture in gui
		lblpic = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("Computer login-pana_1.png")).getImage();
		lblpic.setIcon(new ImageIcon(img));
		lblpic.setBounds(0, 15, 400, 400);

		// initialize and declaration
		lblusr = new JLabel("Username : ");
		lblusr.setBounds(450, 150, 125, 25);
		lblusr.setFont(new Font("Verdana", Font.BOLD, 15));

		txtuser = new JTextField();
		txtuser.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		txtuser.setBounds(560, 150, 200, 25);
	

		lblpass = new JLabel("Password : ");
		lblpass.setBounds(450, 220, 125, 25);
		lblpass.setFont(new Font("Verdana", Font.BOLD, 15));

		pass = new JPasswordField();
		pass.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		pass.setBounds(560, 220, 200, 25);

		btnlogin = new JButton("Login");
		btnlogin.addActionListener(this);
		btnlogin.setBackground(new Color(106, 101, 101));
		btnlogin.setForeground(Color.white);
		btnlogin.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btnlogin.setBounds(525, 300, 90, 25);

		btnregister = new JButton("Create a new account");
		btnregister.setBounds(525, 370, 190, 25);
		btnregister.setBackground(new Color(106, 101, 101));
		btnregister.setForeground(Color.white);
		btnregister.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btnregister.addActionListener(this);

		btnclose = new JButton("Close");
		btnclose.setBounds(625, 300, 85, 25);
		btnclose.setBackground(new Color(106, 101, 101));
		btnclose.setForeground(Color.white);
		btnclose.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btnclose.setFocusable(false);
		btnclose.addActionListener(this);

		// adding in frame
		add(lblpic);
		add(lblusr);
		add(txtuser);
		add(lblpass);
		add(pass);
		add(btnlogin);
		add(btnregister);
		add(btnclose);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// to run the button
		if (ae.getSource() == btnregister) {
			Registrationcustomer book = new Registrationcustomer();
			setVisible(false);
		} else if (ae.getSource() == btnclose) {
			System.exit(0);
		} else if (ae.getSource() == btnlogin) {
			LoginLibs user = new LoginLibs();
			user.setUsername(txtuser.getText());
			user.setPassword(pass.getText());
			// frametoframe.obj1 = user;
			user = new JDBCLogin().login(user);
			if (user.getID() > 0) {
				Global.current_user = user;
				//System.out.println(Global.current_user);
				JOptionPane.showMessageDialog(null, "Welcome " + user.getUsername());
				if (user.getRole().equals("Receptionist")) {
					setVisible(false);
					new ReceptionDashboard();
				} else if (user.getRole().equals("Customer")) {
					new CustomerDashboardGUI();

					setVisible(false);

				} else if (user.getRole().equals("Corp Customer")) {
					setVisible(false);
					new CustomerDashboardGUI();

				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Enter your Correct Username Password");
			}
		}
	}

	public static void main(String[] args) {
		new login();

	}

}