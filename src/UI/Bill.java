package UI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import myLibs.Global;



public class Bill extends JFrame {
	JPanel center;

	//default constructor to set the contents of frame
	public Bill() {
		setTitle("Bill");
		setSize(500, 650);	
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		
		//initialize and memory allocation
		
		center = new JPanel();
		center.setLayout(null);
		center.setPreferredSize(new Dimension(100, 100));
		add(center, BorderLayout.CENTER);
		
		JButton tbn=new JButton("Print");
		tbn.setBounds(50,130,100,20);
		center.add(tbn);
		tbn.addActionListener(new ActionListener() {
//			this is implementation of polymorphism and
//			we have replaced the code in action performed method
			public void actionPerformed(ActionEvent ae) {
				
				PrinterJob job = PrinterJob.getPrinterJob();
	            job.setJobName("Print Data");
	            
	            job.setPrintable(new Printable(){
	            public int print(Graphics pg,PageFormat pf, int pageNum){
	                    pf.setOrientation(PageFormat.LANDSCAPE);
	                 if(pageNum > 0){
	                    return Printable.NO_SUCH_PAGE;
	                }
	                
	                Graphics2D g2 = (Graphics2D)pg;
	                g2.translate(pf.getImageableX(), pf.getImageableY());
	                g2.scale(0.47,0.47);
	                
	                center.print(g2);
	         
	               
	                return Printable.PAGE_EXISTS;
	                         
	                
	            }
	    });
	            boolean ok = job.printDialog();
	        if(ok){
	        try{
	            
	        job.print();
	        }
	        catch (PrinterException ex){
		ex.printStackTrace();
	}
	        }
			
			
			}
			
			
			});
		
		JLabel sep1=new JLabel("----------------------------------------------------------------------");
		sep1.setFont(new Font("Tahoma",Font.PLAIN,18));
		sep1.setBounds(10,150,480,20);
		center.add(sep1);
		
		JLabel heading = new JLabel("Hotel Luton");
		heading.setFont(new Font("Tahoma",Font.BOLD,30));
		heading.setBounds(210,20,480,25);
		center.add(heading);
		
		JLabel heading2 = new JLabel("London, UnitedKingdom");
		heading2.setFont(new Font("Tahoma",Font.PLAIN,20));
		heading2.setBounds(190,55,480,25);
		center.add(heading2);
		
		
		JLabel heading3 = new JLabel("Tel : +44(0)13653004200");
		heading3.setFont(new Font("Tahoma",Font.PLAIN,20));
		heading3.setBounds(190,85,480,25);
		center.add(heading3);
		
		
		JLabel billing=new JLabel("Invoice No: ");
		billing.setFont(new Font("Tahoma",Font.PLAIN,18));
		billing.setBounds(10,200,100,20);
		center.add(billing);
		
		
		Random rand=new Random();
		int random=(int) (Math.random()*500+1);
		
		JLabel billinglbl=new JLabel();
		billinglbl.setText(String.valueOf(random));
		billinglbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		billinglbl.setBounds(120,200,150,20);
		center.add(billinglbl);
		
		JLabel name=new JLabel("Name: ");
		name.setFont(new Font("Tahoma",Font.PLAIN,18));
		name.setBounds(10,240,100,20);
		center.add(name);
		
		JLabel namelbl=new JLabel();
	    namelbl.setText(Global.currentBilling.getName());
		namelbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		namelbl.setBounds(120,240,150,20);
		center.add(namelbl);
		
		JLabel room=new JLabel("Room Amt: ");
		room.setFont(new Font("Tahoma",Font.PLAIN,18));
		room.setBounds(10,280,100,20);
		center.add(room);
		
		JLabel roomlbl=new JLabel();
		roomlbl.setText(Integer.toString(Global.currentBilling.getRoom_Amount()));
		roomlbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		roomlbl.setBounds(120,280,150,20);
		center.add(roomlbl);
		
		JLabel service=new JLabel("Service Amt: ");
		service.setFont(new Font("Tahoma",Font.PLAIN,18));
		service.setBounds(10,320,120,20);
		center.add(service);
		
		JLabel servicelbl=new JLabel();
		servicelbl.setText(Integer.toString(Global.currentBilling.getService_Amount()));
		servicelbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		servicelbl.setBounds(120,320,150,20);
		center.add(servicelbl);
		
		JLabel food=new JLabel("Food Amt: ");
		food.setFont(new Font("Tahoma",Font.PLAIN,18));
		food.setBounds(10,360,120,20);
		center.add(food);
		
		JLabel foodlbl=new JLabel();
		foodlbl.setText(Integer.toString(Global.currentBilling.getFood_Amount()));
		foodlbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		foodlbl.setBounds(120,360,150,20);
		center.add(foodlbl);
		
		JLabel bar=new JLabel("Bar Amt: ");
		bar.setFont(new Font("Tahoma",Font.PLAIN,18));
		bar.setBounds(10,400,120,20);
		center.add(bar);
		
		JLabel barlbl=new JLabel();
		barlbl.setText(Integer.toString(Global.currentBilling.getDrink_Amount()));
		barlbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		barlbl.setBounds(120,400,150,20);
		center.add(barlbl);
		
		JLabel sep=new JLabel("----------------------------------------------------------------------");
		sep.setFont(new Font("Tahoma",Font.PLAIN,18));
		sep.setBounds(10,430,480,20);
		center.add(sep);
		
		JLabel bill=new JLabel("Total Bill: ");
		bill.setFont(new Font("Tahoma",Font.PLAIN,18));
		bill.setBounds(280,450,120,20);
		center.add(bill);
		
		JLabel billlbl=new JLabel();
		billlbl.setText(Double.toString(Global.currentBilling.getTotal_Bill()));
		billlbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		billlbl.setBounds(370,450,150,20);
		center.add(billlbl);
		
		JLabel discount=new JLabel("Discount: ");
		discount.setFont(new Font("Tahoma",Font.PLAIN,18));
		discount.setBounds(280,490,120,20);
		center.add(discount);
		
		JLabel discountlbl=new JLabel();
		discountlbl.setText(Double.toString(Global.currentBilling.getDiscount()));
		discountlbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		discountlbl.setBounds(370,490,150,20);
		center.add(discountlbl);
		
		JLabel paid=new JLabel("Paid Amt: ");
		paid.setFont(new Font("Tahoma",Font.PLAIN,18));
		paid.setBounds(280,530,120,20);
		center.add(paid);
		
		JLabel paidlbl=new JLabel();
		paidlbl.setText(Double.toString(Global.currentBilling.getTotal_Paid()));
		paidlbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		paidlbl.setBounds(370,530,150,20);
		center.add(paidlbl);
		
		JLabel returnlbl=new JLabel("Return Amt: ");
		returnlbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		returnlbl.setBounds(280,570,120,20);
		center.add(returnlbl);
		
		JLabel returnamountlbl=new JLabel();
		returnamountlbl.setText(Double.toString(Global.currentBilling.getReturn_Amount()));
		returnamountlbl.setFont(new Font("Tahoma",Font.PLAIN,18));
		returnamountlbl.setBounds(380,570,150,20);
		center.add(returnamountlbl);

		

		setVisible(true);

	}
	//main method to run the program
	public static void main(String[] args) {
		
		new Bill();
		
	}

}
