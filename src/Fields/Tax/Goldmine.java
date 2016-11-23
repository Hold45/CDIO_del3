package Fields.Tax;

import Game.Game;
import Player.Player;

public class Goldmine extends Tax {
	public Goldmine(Game game) {
		super(game, "GOLDMINENAME","GOLDMINEDESC");
	}

	@Override
	public int getTax(Player player) {
		return 2000;
	}
}
