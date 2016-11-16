package Fields.Refuge;


public class WalledCity extends Refuge {
	public WalledCity() {
		super("nam", "decs", "onLandText");
	}

	@Override
	public int getPayment() {
		return 5000;
	}
}
