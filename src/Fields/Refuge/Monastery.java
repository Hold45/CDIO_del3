package Fields.Refuge;

import Game.Game;

public class Monastery extends Refuge {
	public Monastery(Game game) {
		super(game, "MONASTERYNAME", "MONASTERYDESC", "MONASTERYONLAND");
	}

	@Override
	public int getPayment() {
		return 500;
	}
}
