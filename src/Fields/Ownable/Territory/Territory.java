package Fields.Ownable.Territory;


import Fields.Ownable.Ownable;
import Game.Game;

public abstract class Territory extends Ownable {
	private int rent;


	public Territory(Game game, String name,int price, int rent) {
		super(game, name, "TERRDESC", price);
		this.rent = rent;
	}

	
	@Override
	public int getRent() {
		return this.rent;
	}
	
	@Override
	public String getDecs(){
		return String.format(super.getDecs(), super.getPrice(), this.getRent());
	}

	
}

