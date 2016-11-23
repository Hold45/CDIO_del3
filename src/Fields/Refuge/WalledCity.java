package Fields.Refuge;


import Game.Game;

public class WalledCity extends Refuge {
	public WalledCity(Game game) {
		super(game, "WALLEDCITYNAME", "WALLEDCITYDESC", "WALLEDCITYONLAND");
	}

	@Override
	public int getPayment() {
		return 5000;
	}
}
