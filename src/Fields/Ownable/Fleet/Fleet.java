package Fields.Ownable.Fleet;

import Fields.Ownable.Ownable;
import Game.Game;

public abstract class Fleet extends Ownable {

	public Fleet(Game game, String name, int price) {
		super(game, name, "FLEETDESC", price);

	}

	@Override
	public int getRent() {
		return (int) Math.pow(2,super.getOwner().getNumOfFieldType(this.getClass().getSuperclass())-1)*500;
	}
}
