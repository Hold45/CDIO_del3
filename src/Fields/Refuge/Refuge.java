package Fields.Refuge;

import Fields.Field;
import Game.Game;
import Player.Player;

public abstract class Refuge extends Field {
	private String onLandText;

	public Refuge(Game game, String name, String decs, String onLand) {
		super(game, name, decs);
		this.onLandText = onLand;
	}

	public abstract int getPayment();

	@Override
	public void onLand(Player player) {
		getGame().addMessage(this.onLandText);
		player.getAccount().deposit(getPayment());
	}
}
