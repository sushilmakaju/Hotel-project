package myLibs;

public class BillingLibs {
	
	int B_Id;
	String ArrivalDate;
	String DepartureDate;
	String Name;
	int Room_No;
	int Room_Price;
	int Res_Price;
	int Bar_Price;
	int Service_Charge;
	
	
	public BillingLibs() {
		
		this.B_Id = 0;
		this.ArrivalDate = "";
		this.DepartureDate = "";
		this.Name = "";
		this.Room_No = 0;
		this.Room_Price = 0;
		this.Res_Price = 0;
		this.Bar_Price = 0;
		this.Service_Charge = 0;
	}
	
	
	public BillingLibs(int b_Id, String arrivalDate, String departureDate, String name, int room_No, int room_Price,
			int res_Price, int bar_Price, int service_Charge) {
		
		this.B_Id = b_Id;
		this.ArrivalDate = arrivalDate;
		this.DepartureDate = departureDate;
		this.Name = name;
		this.Room_No = room_No;
		this.Room_Price = room_Price;
		this.Res_Price = res_Price;
		this.Bar_Price = bar_Price;
		this.Service_Charge = service_Charge;
	}


	public int getB_Id() {
		return B_Id;
	}


	public void setB_Id(int b_Id) {
		B_Id = b_Id;
	}


	public String getArrivalDate() {
		return ArrivalDate;
	}


	public void setArrivalDate(String arrivalDate) {
		ArrivalDate = arrivalDate;
	}


	public String getDepartureDate() {
		return DepartureDate;
	}


	public void setDepartureDate(String departureDate) {
		DepartureDate = departureDate;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getRoom_No() {
		return Room_No;
	}


	public void setRoom_No(int room_No) {
		Room_No = room_No;
	}


	public int getRoom_Price() {
		return Room_Price;
	}


	public void setRoom_Price(int room_Price) {
		Room_Price = room_Price;
	}


	public int getRes_Price() {
		return Res_Price;
	}


	public void setRes_Price(int res_Price) {
		Res_Price = res_Price;
	}


	public int getBar_Price() {
		return Bar_Price;
	}


	public void setBar_Price(int bar_Price) {
		Bar_Price = bar_Price;
	}


	public int getService_Charge() {
		return Service_Charge;
	}


	public void setService_Charge(int service_Charge) {
		Service_Charge = service_Charge;
	}


	@Override
	public String toString() {
		return "BillingLibs [B_Id=" + B_Id + ", ArrivalDate=" + ArrivalDate + ", DepartureDate=" + DepartureDate
				+ ", Name=" + Name + ", Room_No=" + Room_No + ", Room_Price=" + Room_Price + ", Res_Price=" + Res_Price
				+ ", Bar_Price=" + Bar_Price + ", Service_Charge=" + Service_Charge + "]";
	}
	
	
}
