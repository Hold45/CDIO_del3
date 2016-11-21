package Fields.Ownable.Territory;


import Fields.Ownable.Ownable;

public abstract class Territory extends Ownable {
	private int rent;


	public Territory(String name, String decs, String onLandText, int price, int rent) {
		super(name, decs, onLandText, price);
		this.rent = rent;
	}

	
	@Override
	public int getRent() {
		return this.rent;
	}
	

	
}

