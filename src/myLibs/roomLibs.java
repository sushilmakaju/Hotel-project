package myLibs;

public class roomLibs {
	int Room_no;
	String Room_type;
	String Room_status;
	double price;
	
	
	public roomLibs() {
		super();
		this.Room_no = 0;
		this.Room_type = "";
		this.Room_status = "";
		this.price = 0;
	}
	
	
	public roomLibs(int room_no, String room_type, String room_status, double price) {

		Room_no = room_no;
		Room_type = room_type;
		Room_status = room_status;
		this.price = price;
	}


	public int getRoom_no() {
		return Room_no;
	}


	public void setRoom_no(int room_no) {
		Room_no = room_no;
	}


	public String getRoom_type() {
		return Room_type;
	}


	public void setRoom_type(String room_type) {
		Room_type = room_type;
	}


	public String getRoom_status() {
		return Room_status;
	}


	public void setRoom_status(String room_status) {
		Room_status = room_status;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "roomLibs [Room_no=" + Room_no + ", Room_type=" + Room_type + ", Room_status=" + Room_status + ", price="
				+ price + "]";
	}
	
	
	
	
	
	

}
