package myLibs;

public class ServiceLibs {
	int serviceid;
	String servicetype;
	int serviceprice;
	int bookingid;

	public ServiceLibs() {
		
		this.serviceid = 0;
		this.servicetype = "";
		this.serviceprice = 0;
		this.bookingid = 0;
	}

	public ServiceLibs(int serviceid, String servicetype, int serviceprice, int bookingid) {

		this.serviceid = serviceid;
		this.servicetype = servicetype;
		this.serviceprice = serviceprice;
		this.bookingid = bookingid;
	}

	public int getServiceid() {
		return serviceid;
	}

	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}

	public String getServicetype() {
		return servicetype;
	}

	public void setServicetype(String servicetype) {
		this.servicetype = servicetype;
	}

	public int getServiceprice() {
		return serviceprice;
	}

	public void setServiceprice(int serviceprice) {
		this.serviceprice = serviceprice;
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	@Override
	public String toString() {
		return "ServiceLibs [serviceid=" + serviceid + ", servicetype=" + servicetype + ", serviceprice=" + serviceprice
				+ ", bookingid=" + bookingid + "]";
	}

}
	
	

	