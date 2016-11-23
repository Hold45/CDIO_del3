package Fields;

import Fields.Ownable.Fleet.PrivateerArmade;
import Fields.Ownable.Fleet.SeaGrover;
import Fields.Ownable.Fleet.SecondSail;
import Fields.Ownable.Fleet.TheBuccaneers;
import Fields.Ownable.LaborCamp.HutsInTheMountain;
import Fields.Ownable.LaborCamp.ThePit;
import Fields.Ownable.Territory.Crater;
import Fields.Refuge.Monastery;
import Fields.Refuge.WalledCity;
import Fields.Tax.Caravan;
import Fields.Tax.Goldmine;
import Player.Player;

public class Board {

	private Field[] fields;
	
	public Board()
	{
		this.fields = new Field[]{
				new Crater(),
				new HutsInTheMountain(),
				new SecondSail(),
				new Monastery(),
				new WalledCity(),
				new Caravan(),
				new Goldmine(),
				new SeaGrover(),
				new TheBuccaneers(),
				new PrivateerArmade(),
				new ThePit()
		};
	}

	public void move(Player player, int amount){
		player.setPosition((player.getPosition()+amount)%this.fields.length);
		this.fields[player.getPosition()].onLand(player);
	}

	public Field[] getFields() {
		return fields;
	}


	public int getPosition(Field field){
		for (int i = 0; i < this.fields.length; i++) {
			if(this.fields[i].getName().equals(field.getName())){
				return i;
			}
		}
		return 0;
	}

}
