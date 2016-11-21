package GUI;

import Fields.Field;
import Game.Game;
import Player.Player;
import desktop_fields.Empty;
import Ownable.*;

import java.util.ArrayList;
import java.util.stream.Stream;


public class GUI {

	private ArrayList<desktop_fields.Field> fields = new ArrayList<>();

	public static  void main(String... args){
		GUI gui = new GUI();
		Game game = new Game(gui);

		gui.createBoard(game);


		gui.addPlayers(game);

		game.start();

	}

	private void createBoard(Game game){
		Field[] fields = game.getBoard().getFields();

		Stream.of(fields).forEach(this::addField);

		for (int i = fields.length; i < 40 ; i++) {
			this.fields.add(new Empty.Builder().build());
		}


		desktop_fields.Field[] guiFields = new desktop_fields.Field[40];
		guiFields = this.fields.toArray(guiFields);
		desktop_resources.GUI.create(guiFields);
	}

	private void addField(Field field){
		desktop_fields.Field guiField = new SpaceType.Builder().build();
		guiField.setTitle(field.getName());
		guiField.setDescription(field.getDecs());
		this.fields.add(guiField);
	}

	private void addPlayers(Game game) {
		int playerNum = this.getInteger("Select number of players between 2-6", 2,6);

		for (int i = 1; i < playerNum+1; i++) {
			String name = this.getString("Enter name of player "+i);
			if(!game.addPlayer(name)){
				name = this.getString("Player name already exist. Enter name of player "+i);
				while (!game.addPlayer(name));
			}
			this.addPlayer(game.getPlayer(name));
		}
	}

	public int getInteger(String text, int start, int end){
		return desktop_resources.GUI.getUserInteger(text, start, end);
	}

	public String getString(String text){
		return desktop_resources.GUI.getUserString(text);
	}

	private void setPosition(Player player){
		desktop_resources.GUI.removeAllCars(player.getName());
		desktop_resources.GUI.setCar(player.getPosition()+1, player.getName());
	}

	private void setBalance(Player player){
		desktop_resources.GUI.setBalance(player.getName(), player.getAccount().getBalance());
	}

	private void setOwns(Player player){

		for (Ownable field: player.getOwns()) {
			desktop_resources.GUI.setOwner(player.getGame().getBoard().getPosition(field)+1, player.getName());
			desktop_resources.GUI.setHouses(player.getGame().getBoard().getPosition(field)+1,1);
		}
	}


	private void setDice(int... values){
		desktop_resources.GUI.setDice(values[0], values[1]);
	}

	private void addPlayer(Player player){
		desktop_resources.GUI.addPlayer(player.getName(), player.getAccount().getBalance());
	}


	public void updateUI(Game game){
		this.setDice(game.getDiceCup().getValues());

		for (Player player: game.getPlayers()) {
			this.setPosition(player);
			this.setBalance(player);
			this.setOwns(player);
		}

		//desktop_resources.GUI.showMessage(game.getMessage());
	}

}
