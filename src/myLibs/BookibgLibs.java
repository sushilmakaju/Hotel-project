package myLibs;

public class BookibgLibs {
	int Bookingid;
	String Arrivaldate;
	String Departuredate;
	String bookingtype;
	String bookingstatus;
	int Customerid;
	int roomno;

	public BookibgLibs() {
		this.Bookingid = 0;
		this.Arrivaldate = "";
		this.Departuredate = "";
		this.bookingtype = "";
		this.bookingstatus = "";
		this.Customerid = 0;
		this.roomno = 0;
	}

	public BookibgLibs(int bookingid, String arrivaldate, String departuredate, String bookingtype,	String bookingstatus, int customerid, int roomno) {
		this.Bookingid = bookingid;
		this.Arrivaldate = arrivaldate;
		this.Departuredate = departuredate;
		this.bookingtype = bookingtype;
		this.bookingstatus = bookingstatus;
		this.Customerid = customerid;
		this.roomno = roomno;
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

	public int getCustomerid() {
		return Customerid;
	}

	public void setCustomerid(int customerid) {
		Customerid = customerid;
	}

	public int getRoomno() {
		return roomno;
	}

	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}

	@Override
	public String toString() {
		return "BookibgLibs [Bookingid=" + Bookingid + ", Arrivaldate=" + Arrivaldate + ", Departuredate="
				+ Departuredate + ", bookingtype=" + bookingtype + ", bookingstatus=" + bookingstatus + ", Customerid="
				+ Customerid + ", roomno=" + roomno + "]";
	}
	
	
	
	
	




}
	

	