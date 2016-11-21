package Fields;

import Fields.Refuge.Monastery;
import Fields.Refuge.WalledCity;
import Fields.Tax.Caravan;
import Ownable.Crater;
import Ownable.HutsInTheMountain;
import Ownable.SecondSail;
import Player.Player;
import Ownable.*;

import java.util.Objects;
import java.util.stream.Stream;

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
				new Caravan()
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
