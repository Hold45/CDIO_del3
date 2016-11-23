package Fields.Tax;

import Fields.Field;
import Game.Game;
import Player.Player;

public abstract class Tax extends Field {

	public Tax(Game game, String name, String decs) {
		super(game, name, decs);
	}

	public abstract int getTax(Player player);

	@Override
	public void onLand(Player player) {
		getGame().addMessage("TAXONLAND", Integer.toString(getTax(player)));
		player.getAccount().withdraw(getTax(player));
	}
}
