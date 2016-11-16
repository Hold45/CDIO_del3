package Fields.Tax;

import Fields.Field;
import Player.Player;

public abstract class Tax extends Field {

	public Tax(String name, String decs, String onLandText) {
		super(name, decs, onLandText);
	}

	public abstract int getTax(Player player);

	@Override
	public void onLand(Player player) {
		super.onLand(player);
		player.getAccount().withdraw(getTax(player));
	}
}
