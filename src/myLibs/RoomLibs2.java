package myLibs;

public class RoomLibs2 {
	
	int Room_No;
	String Room_Type;
	Double Room_Price;
	String Room_Status;
	
	
	public RoomLibs2() {


		this.Room_No = 0;
		this.Room_Type = "";
		this.Room_Price = 0.0;
		this.Room_Status = "";
	}
	
	
	public RoomLibs2(int room_No, String room_Type, Double room_Price, String room_Status) {


		this.Room_No = room_No;
		this.Room_Type = room_Type;
		this.Room_Price = room_Price;
		this.Room_Status = room_Status;
	}


	public int getRoom_No() {
		return Room_No;
	}


	public void setRoom_No(int room_No) {
		Room_No = room_No;
	}


	public String getRoom_Type() {
		return Room_Type;
	}


	public void setRoom_Type(String room_Type) {
		Room_Type = room_Type;
	}


	public Double getRoom_Price() {
		return Room_Price;
	}


	public void setRoom_Price(Double room_Price) {
		Room_Price = room_Price;
	}


	public String getRoom_Status() {
		return Room_Status;
	}


	public void setRoom_Status(String room_Status) {
		Room_Status = room_Status;
	}


	@Override
	public String toString() {
		return "RoomLibs2 [Room_No=" + Room_No + ", Room_Type=" + Room_Type + ", Room_Price=" + Room_Price
				+ ", Room_Status=" + Room_Status + "]";
	}
	
	
	

}
