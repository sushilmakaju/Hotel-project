package myLibs;

public class bookinglibs3 {
	int Customerid;
	String Name;
	int Bookingid;
	String Arrivaldate;
	String Departuredate;
	String bookingtype;
	String bookingstatus;
	int roomno;
	
	public bookinglibs3() {
		this.Customerid = 0;
		this.Name = "";
		this.Bookingid = 0;
		this.Arrivaldate = "";
		this.Departuredate = "";
		this.bookingtype = "";
		this.bookingstatus = "";
		this.roomno = 0;
	}

	public bookinglibs3(int customerid, String name, int bookingid, String arrivaldate, String departuredate,
			String bookingtype, String bookingstatus, int roomno) {
		
		this.Customerid = customerid;
		this.Name = name;
		this.Bookingid = bookingid;
		this.Arrivaldate = arrivaldate;
		this.Departuredate = departuredate;
		this.bookingtype = bookingtype;
		this.bookingstatus = bookingstatus;
		this.roomno = roomno;
	}

	public int getCustomerid() {
		return Customerid;
	}

	public void setCustomerid(int customerid) {
		Customerid = customerid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getBookingid() {
		return Bookingid;
	}

	public void setBookingid(int bookingid) {
		Bookingid = bookingid;
	}

	public String getArrivaldate() {
		return Arrivaldate;
	}

	public void setArrivaldate(String arrivaldate) {
		Arrivaldate = arrivaldate;
	}

	public String getDeparturedate() {
		return Departuredate;
	}

	public void setDeparturedate(String departuredate) {
		Departuredate = departuredate;
	}

	public String getBookingtype() {
		return bookingtype;
	}

	public void setBookingtype(String bookingtype) {
		this.bookingtype = bookingtype;
	}

	public String getBookingstatus() {
		return bookingstatus;
	}

	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}

	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}

	@Override
	public String toString() {
		return "bookinglibs3 [Customerid=" + Customerid + ", Name=" + Name + ", Bookingid=" + Bookingid
				+ ", Arrivaldate=" + Arrivaldate + ", Departuredate=" + Departuredate + ", bookingtype=" + bookingtype
				+ ", bookingstatus=" + bookingstatus + ", roomno=" + roomno + "]";
	}
	
	
	

}
