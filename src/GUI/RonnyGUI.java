package GUI;

import Fields.Board;
import Fields.Field;
import Game.Game;
import Player.Player;
import desktop_fields.Empty;
import Fields.Ownable.*;

import java.util.ArrayList;
import java.util.stream.Stream;


public class RonnyGUI implements GUI{

	private ArrayList<desktop_fields.Field> fields = new ArrayList<>();

	public static  void main(String... args){
		RonnyGUI gui = new RonnyGUI();
		Game game = new Game(gui);

		gui.createBoard(game);


		gui.addPlayers(game);

		game.start();

	}

	@Override
	public void createBoard(Game game){
		Field[] fields = game.getBoard().getFields();

		Stream.of(fields).forEach(this::addField);

		for (int i = fields.length; i < 40 ; i++) {
			this.fields.add(new Empty.Builder().build());
		}


		desktop_fields.Field[] guiFields = new desktop_fields.Field[40];
		guiFields = this.fields.toArray(guiFields);
		desktop_resources.GUI.create(guiFields);
	}

	@Override
	public void showMessage(String message) {
		desktop_resources.GUI.showMessage(message);
	}

	@Override
	public void addField(Field field){
		desktop_fields.Field guiField = new FieldTypeGUI.Builder().build();
		guiField.setTitle(field.getName());
		guiField.setDescription(field.getDecs());
		this.fields.add(guiField);
	}

	@Override
	public void addPlayers(Game game) {
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

	@Override
	public int getInteger(String text, int start, int end){
		return desktop_resources.GUI.getUserInteger(text, start, end);
	}

	@Override
	public String getString(String text){
		return desktop_resources.GUI.getUserString(text);
	}

	@Override
	public void setPosition(Player player){
		desktop_resources.GUI.removeAllCars(player.getName());
		desktop_resources.GUI.setCar(player.getPosition()+1, player.getName());
	}

	@Override
	public void setBalance(Player player){
		desktop_resources.GUI.setBalance(player.getName(), player.getAccount().getBalance());
	}

	@Override
	public void setOwners(Board board){
		for (int i = 0; i < board.getFields().length; i++) {
			if(board.getFields()[i] instanceof Ownable){
				Ownable ownable = (Ownable) board.getFields()[i];
				desktop_resources.GUI.removeOwner(i+1);
				if(ownable.isOwned()){
					desktop_resources.GUI.setOwner(i+1,ownable.getOwner().getName());
				}
			}
		}
	}

	@Override
	public void setDice(int... values){
		desktop_resources.GUI.setDice(values[0], values[1]);
	}

	@Override
	public void addPlayer(Player player){
		desktop_resources.GUI.addPlayer(player.getName(), player.getAccount().getBalance());
	}


	@Override
	public void updateUI(Game game){
		this.setDice(game.getDiceCup().getValues());

		for (Player player: game.getPlayers()) {
			this.setPosition(player);
			this.setBalance(player);
		}
		this.setOwners(game.getBoard());
		game.getLosers().stream().forEach(player -> desktop_resources.GUI.removeCar(player.getPosition(),player.getName()));

		while (!game.getMessage().isEmpty()){
			desktop_resources.GUI.showMessage(game.getMessage().pop());
		}
}

}
