package Fields.Tax;


import Fields.Ownable.*;
import Game.Game;
import Player.Player;

public class Caravan extends Tax{
	public Caravan(Game game) {
		super(game, "CARAVANNAME", "CARAVANDESC");
	}

	@Override
	public int getTax(Player player) {
		return Math.min((player.getOwns().stream().mapToInt(Ownable::getPrice).sum()+player.getAccount().getBalance())/10, 4000);
	}
}
