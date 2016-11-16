package Fields.Refuge;

import Fields.Field;
import Player.Player;

public abstract class Refuge extends Field {
	public Refuge(String name, String decs, String onLandText) {
		super(name, decs, onLandText);
	}

	public abstract int getPayment();

	@Override
	public void onLand(Player player) {
		super.onLand(player);

		player.getAccount().deposit(getPayment());
	}
}
