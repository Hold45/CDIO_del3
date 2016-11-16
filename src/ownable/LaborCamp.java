package ownable;

public abstract class LaborCamp extends Ownable {

	public LaborCamp(String name, String decs, String onLandText, int price) {
		super(name, decs, onLandText, price);
	}

	@Override
	public int getRent() {
		super.getOwner().getGame().getDiceCup().getValue() //TODO: finish this shit
	}
}
