package Ownable;

public abstract class Fleet extends Ownable {

	public Fleet(String name, String decs, String onLandText, int price) {
		super(name, decs, onLandText, price);

	}

	@Override
	public int getRent() {
		return (int) Math.pow(2,super.getOwner().getNumOfFieldType(this)-1)*500;
	}
}
