package model;

public class BilledProduct extends Product{
	private int quantity;

	public BilledProduct(Product p,int quantity) {
		super();
		this.quantity = quantity;
		super.setId(p.getId());
		super.setName(p.getName());
		super.setPrice(p.getPrice());
	}

	

	public BilledProduct() {
		// TODO Auto-generated constructor stub
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	
	
	
}
