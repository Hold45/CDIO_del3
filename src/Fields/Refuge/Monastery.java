package Fields.Refuge;

public class Monastery extends Refuge {
	public Monastery() {
		super("name", "decs", "onLandText");
	}

	@Override
	public int getPayment() {
		return 500;
	}
}
