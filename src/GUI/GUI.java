package GUI;

import Fields.Board;
import Fields.Field;
import Game.Game;
import Player.Player;

public interface GUI {

	void updateUI(Game game);
	void addPlayer(Player player);
	void setDice(int... values);
	void setOwners(Board board);
	void setBalance(Player player);
	void setPosition(Player player);
	String getString(String text);
	int getInteger(String text, int start, int end);
	void addPlayers(Game game);
	void addField(Field field);
	void createBoard(Game game);
	void showMessage(String message);

}

//test
