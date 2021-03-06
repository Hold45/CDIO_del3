package Player;
import java.util.ArrayList;
import static java.lang.Math.toIntExact;

import Fields.*;
import Game.*;
import Fields.Ownable.*;


public class Player {

	private String name;
	private Game game;
	private Account account;
	private ArrayList<Ownable> owns;
	private int position;



	public Player (String name, Game game)
	{
		this.name = name;
		this.game = game;
		this.account = new Account(this);
		this.owns = new ArrayList<>();
		position = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Game getGame() {
		return game;
	}

	public Account getAccount() {
		return account;
	}

	public ArrayList<Ownable> getOwns() {
		return owns;
	}
	
	public void addField(Ownable field){
		this.owns.add(field);
	}
	
	public boolean tryPurchase(Ownable field){
		if(this.getAccount().getBalance() >= field.getPrice()){
			field.purchase(this);
			return true;
		}
		return false;
	}

	public int getNumOfFieldType(Class field){
		return toIntExact(this.owns.stream().filter(ownable -> field.isAssignableFrom(ownable.getClass())).count());
	}

	public void takeTurn() {
		this.game.getBoard().move(this, this.game.getDiceCup().roll().getSum());
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
}


