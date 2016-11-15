package game;
import fields.*;
import player.Player;

import java.util.ArrayList;

public class Game {
	
	private Board board;
	
	private ArrayList<String> message;
	private ArrayList<Player> losers;
	
	public Game(){
		this.board = new Board();
	}
	
	
	public void addMessage (String msg) {
		this.message.add(msg);
	}

	public ArrayList<String> getMessage() {
		return message;
	}


	public void addLoser(Player loser) {
		this.losers.add(loser);
	}

}
