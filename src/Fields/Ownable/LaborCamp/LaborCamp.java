package Fields.Ownable.LaborCamp;

import Fields.Ownable.Ownable;
import Game.Game;

public abstract class LaborCamp extends Ownable {

	public LaborCamp(Game game, String name, String decs, int price) {
		super(game, name, decs, price);
	}

	@Override
	public int getRent() {
		return super.getOwner().getNumOfFieldType(this.getClass().getSuperclass())*100*super.getOwner().getGame().getDiceCup().getSum();
	}
}
