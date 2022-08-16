package entities;

public class ImportedProduct extends Product{

	private Double customFee;

	public ImportedProduct() {
		super();
	}

	public ImportedProduct(String name, double price, Double customFee) {
		super(name, price);
		this.customFee = customFee;
	}

	public Double getCustomFee() {
		return customFee;
	}

	public void setCustomFee(Double customFee) {
		this.customFee = customFee;
	}
	
	public double totalPrice() {
		return getPrice() + customFee;
	}
	
	@Override
	public final String priceTag() {
		return getName()
				+ " $"
				+ totalPrice()
				+ " (Customs fee: $"
				+ String.format("%.2f", customFee)
				+ ")"; 
	}
	
}
