package myLibs;

public class BillingLibs2 {
	
	int Billing_ID;
	String Name;
	int Drink_Amount;
	int Service_Amount;
	int Food_Amount;
	int Room_Amount;
	double Total_Bill;
	double Total_Paid;
	double Return_Amount;
	double Discount;
	String Billing_Status;
	
	
	
	public BillingLibs2() {
		
		this.Billing_ID = 0;
		this.Name = "";
		this.Drink_Amount = 0;
		this.Service_Amount = 0;
		this.Food_Amount = 0;
		this.Room_Amount = 0;
		this.Total_Bill = 0.0;
		this.Total_Paid = 0.0;
		this.Return_Amount = 0.0;
		this.Discount = 0.0;
		this.Billing_Status = "";
	}
	
	
	public BillingLibs2(int billing_ID, String name, int drink_Amount, int service_Amount, int food_Amount,
			int room_Amount, double total_Bill, double total_Paid, double return_Amount, double discount,
			String billing_Status) {
		
		this.Billing_ID = billing_ID;
		this.Name = name;
		this.Drink_Amount = drink_Amount;
		this.Service_Amount = service_Amount;
		this.Food_Amount = food_Amount;
		this.Room_Amount = room_Amount;
		this.Total_Bill = total_Bill;
		this.Total_Paid = total_Paid;
		this.Return_Amount = return_Amount;
		this.Discount = discount;
		this.Billing_Status = billing_Status;
	}


	public int getBilling_ID() {
		return Billing_ID;
	}


	public void setBilling_ID(int billing_ID) {
		Billing_ID = billing_ID;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getDrink_Amount() {
		return Drink_Amount;
	}


	public void setDrink_Amount(int drink_Amount) {
		Drink_Amount = drink_Amount;
	}


	public int getService_Amount() {
		return Service_Amount;
	}


	public void setService_Amount(int service_Amount) {
		Service_Amount = service_Amount;
	}


	public int getFood_Amount() {
		return Food_Amount;
	}


	public void setFood_Amount(int food_Amount) {
		Food_Amount = food_Amount;
	}


	public int getRoom_Amount() {
		return Room_Amount;
	}


	public void setRoom_Amount(int room_Amount) {
		Room_Amount = room_Amount;
	}


	public double getTotal_Bill() {
		return Total_Bill;
	}


	public void setTotal_Bill(double total_Bill) {
		Total_Bill = total_Bill;
	}


	public double getTotal_Paid() {
		return Total_Paid;
	}


	public void setTotal_Paid(double total_Paid) {
		Total_Paid = total_Paid;
	}


	public double getReturn_Amount() {
		return Return_Amount;
	}


	public void setReturn_Amount(double return_Amount) {
		Return_Amount = return_Amount;
	}


	public double getDiscount() {
		return Discount;
	}


	public void setDiscount(double discount) {
		Discount = discount;
	}


	public String getBilling_Status() {
		return Billing_Status;
	}


	public void setBilling_Status(String billing_Status) {
		Billing_Status = billing_Status;
	}


	@Override
	public String toString() {
		return "BillingLibs2 [Billing_ID=" + Billing_ID + ", Name=" + Name + ", Drink_Amount=" + Drink_Amount
				+ ", Service_Amount=" + Service_Amount + ", Food_Amount=" + Food_Amount + ", Room_Amount=" + Room_Amount
				+ ", Total_Bill=" + Total_Bill + ", Total_Paid=" + Total_Paid + ", Return_Amount=" + Return_Amount
				+ ", Discount=" + Discount + ", Billing_Status=" + Billing_Status + "]";
	}
	
}
