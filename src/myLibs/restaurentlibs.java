package myLibs;

public class restaurentlibs {
	int foodid;
	String fooditem;
	int price;
	int bookingid;
	
	
	public restaurentlibs() {
		this.foodid = 0;
		this.fooditem = "";
		this.price = 0;
		this.bookingid = 0;
	}


	public restaurentlibs(int foodid, String fooditem, int price, int bookingid) {
		super();
		this.foodid = foodid;
		this.fooditem = fooditem;
		this.price = price;
		this.bookingid = bookingid;
	}


	public int getFoodid() {
		return foodid;
	}


	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}


	public String getFooditem() {
		return fooditem;
	}


	public void setFooditem(String fooditem) {
		this.fooditem = fooditem;
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
		return "restaurentlibs [foodid=" + foodid + ", fooditem=" + fooditem + ", price=" + price + ", bookingid="
				+ bookingid + "]";
	}

}
	
	