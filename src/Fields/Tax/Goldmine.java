package Fields.Tax;

import Player.Player;

public class Goldmine extends Tax {
	public Goldmine() {
		super("goldmine","decs", "onLandText");
	}

	@Override
	public int getTax(Player player) {
		return 2000;
	}
}
