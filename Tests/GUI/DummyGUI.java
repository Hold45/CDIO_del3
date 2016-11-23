package GUI;

import Fields.Board;
import Fields.Field;
import Game.Game;
import Player.Player;

public class DummyGUI implements GUI {
	@Override
	public void updateUI(Game game) {

	}

	@Override
	public void addPlayer(Player player) {

	}

	@Override
	public void setDice(int... values) {

	}

	@Override
	public void setOwners(Board board) {

	}

	@Override
	public String getString(String text) {
		return null;
	}

	@Override
	public int getInteger(String text, int start, int end) {
		return 0;
	}

	@Override
	public void addField(Field field) {

	}

	@Override
	public void showMessage(String message) {

	}

	@Override
	public void createBoard(Game game) {

	}

	@Override
	public void addPlayers(Game game) {

	}

	@Override
	public void setPosition(Player player) {

	}

	@Override
	public void setBalance(Player player) {

	}
}
