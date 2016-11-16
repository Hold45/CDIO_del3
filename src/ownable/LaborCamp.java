package Ownable;

public abstract class LaborCamp extends Ownable {

	public LaborCamp(String name, String decs, String onLandText, int price) {
		super(name, decs, onLandText, price);
	}

	@Override
	public int getRent() {
		return super.getOwner().getNumOfFieldType(this)*100*super.getOwner().getGame().getDiceCup().getSum();
	}
}
