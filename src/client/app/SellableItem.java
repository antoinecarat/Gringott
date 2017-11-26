package client.app;

public class SellableItem implements Item {

	private static final long serialVersionUID = -4517882019233732317L;
	private String name;
	private String description;
	private String leader;
	private double price;
	private boolean sold;
	
	
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public String getLeader() {
		return this.leader;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public boolean isSold() {
		return this.sold;
	}

	@Override
	public void setLeader(String leader) {
		this.leader = leader;
	}

	@Override
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public void setSold(boolean status) {
		this.sold = status;
	}

}
