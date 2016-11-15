package player;
import java.util.ArrayList;

import fields.*;
import game.*;
import ownable.Ownable;

public class Player {

	private String name;
	private int value;
	private Game game;
	private Account account;
	private ArrayList<Field> fields;



	public Player (String name, int value, Game game)
	{
		this.game = game;
		this.account = new Account(this);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Game getGame() {
		return game;
	}

	public Account getAccount() {
		return account;
	}

	public ArrayList<Field> getFields() {
		return fields;
	}
	
	public void addField(Field field){
		this.fields.add(field);
	}
	
	public void tryPurchase(Ownable field){
		if(this.getAccount().getBalance() >= field.getPrice()){
			field.purchase(this);
		}
	}


}


