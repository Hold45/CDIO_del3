package Fields;

import Fields.Ownable.Fleet.PrivateerArmade;
import Fields.Ownable.Fleet.SeaGrover;
import Fields.Ownable.Fleet.SecondSail;
import Fields.Ownable.Fleet.TheBuccaneers;
import Fields.Ownable.LaborCamp.HutsInTheMountain;
import Fields.Ownable.LaborCamp.ThePit;
import Fields.Ownable.Territory.*;
import Fields.Refuge.Monastery;
import Fields.Refuge.WalledCity;
import Fields.Tax.Caravan;
import Fields.Tax.Goldmine;
import Game.Game;
import Player.Player;

public class Board {

	private Field[] fields;
	
	public Board(Game game)
	{
		this.fields = new Field[]{
				new TribeEncampment(game),
				new Crater(game),
				new Mountain(game),
				new ColdDesert(game),
				new BlackCave(game),
				new TheWerewall(game),
				new MountainVillage(game),
				new SouthCitadel(game),
				new PalaceGates(game),
				new Tower(game),
				new Castle(game),
				new WalledCity(game),
				new Monastery(game),
				new HutsInTheMountain(game),
				new ThePit(game),
				new Goldmine(game),
				new Caravan(game),
				new SecondSail(game),
				new SeaGrover(game),
				new TheBuccaneers(game),
				new PrivateerArmade(game)
		};
	}

	public void move(Player player, int amount){
		player.setPosition((player.getPosition()+amount)%this.fields.length);
		this.fields[player.getPosition()].onLand(player);
	}

	public Field[] getFields() {
		return fields;
	}
}
