package myLibs;

public class barlibs {
	int bar_id;
	String baritem;
	int price;
	int bookingid;
	
	public barlibs() {

		this.bar_id = 0;
		this.baritem ="";
		this.price = 0;
		this.bookingid = 0;
	}

	public barlibs(int bar_id, String baritem, int price, int bookingid) {

		this.bar_id = bar_id;
		this.baritem = baritem;
		this.price = price;
		this.bookingid = bookingid;
	}

	public int getBar_id() {
		return bar_id;
	}

	public void setBar_id(int bar_id) {
		this.bar_id = bar_id;
	}

	public String getBaritem() {
		return baritem;
	}

	public void setBaritem(String baritem) {
		this.baritem = baritem;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBookingid() {
		return bookingid;
	}

	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}

	@Override
	public String toString() {
		return "barlibs [bar_id=" + bar_id + ", baritem=" + baritem + ", price=" + price + ", bookingid=" + bookingid
				+ "]";
	}
	
}
	
	
	
	
	
	