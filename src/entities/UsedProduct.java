package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product{

	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date manufectureDate;

	public UsedProduct() {
		super();
	}

	public UsedProduct(String name, double price, Date manufectureDate) {
		super(name, price);
		this.manufectureDate = manufectureDate;
	}

	public Date getManufectureDate() {
		return manufectureDate;
	}

	public void setManufectureDate(Date manufectureDate) {
		this.manufectureDate = manufectureDate;
	}
	
	@Override
	public final String priceTag() {
		return getName() 
				+ " (used) $" 
				+ String.format("%.2f", getPrice()) 
				+ " (Manufacture date: " 
				+ sdf.format(manufectureDate)
				+ ")";
	}
	
}
