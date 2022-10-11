package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WelcomePage extends JFrame implements ActionListener{
	JPanel pane1, pane2, pane3;
	JLabel lbl, lblpic;
	JButton btnlogin;
	

	//default constructor to set the contents of frame
	public WelcomePage() {
		setTitle("Welcomepage");
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new BorderLayout());
		//to set the fullscreen 
		setExtendedState(MAXIMIZED_BOTH);
		
		//initialize and memory allocation
		JPanel panel=new JPanel();
		panel.setBackground(new Color(106, 101, 101));
		panel.setPreferredSize(new Dimension(10,80));
		panel.setLayout(null);
		add(panel,BorderLayout.NORTH);
		
		
		JLabel lbl=new JLabel("Welcome To Luton Hotel", JLabel.CENTER);
		lbl.setBounds(450,15,400,55);
		lbl.setForeground(Color.white);
		lbl.setFont(new Font("Tahoma",Font.BOLD,20));
		panel.add(lbl);
		
		btnlogin=new JButton("Login");
		btnlogin.setBounds(1170,50,80,25);
		btnlogin.setBackground(new Color(106, 101, 101));
		btnlogin.setForeground(Color.white);
		btnlogin.setBorder(BorderFactory.createLineBorder(Color.white, 1));
		btnlogin.setFocusable(false);
		btnlogin.addActionListener(this);
		panel.add(btnlogin);
		
		
		
		JLabel lbl1=new JLabel();
		lbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("welcomepage1.jpg")));		
		add(lbl1,BorderLayout.CENTER);

		setVisible(true);
		
	}
//	this is implementation of polymorphism and
//	we have replaced the code in action performed method
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==btnlogin) {
			login Login = new login();
			
		}
	}

	//main method to run the program
	public static void main(String[] args) {
		new WelcomePage();

	}

}
