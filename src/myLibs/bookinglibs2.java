package myLibs;

public class bookinglibs2 {
	int Bookingid;
	String Arrivaldate;
	String Departuredate;
	String bookingtype;
	String bookingstatus;
	int Customerid;
	
	public bookinglibs2() {
		this.Bookingid = 0;
		this.Arrivaldate = "";
		this.Departuredate = "";
		this.bookingtype = "";
		this.bookingstatus = "";
		this.Customerid = 0;
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

	@Override
	public String toString() {
		return "bookinglibs2 [Bookingid=" + Bookingid + ", Arrivaldate=" + Arrivaldate + ", Departuredate="
				+ Departuredate + ", bookingtype=" + bookingtype + ", bookingstatus=" + bookingstatus + ", Customerid="
				+ Customerid + "]";
	}
	
	
		

}
