package Game;
import Die.D6;
import Die.DiceCup;
import Fields.*;
import Fields.Ownable.*;
import Player.Player;
import GUI.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Stack;

public class Game {
	
	private Board board;
	
	private Stack<String> message;
	private ArrayList<Player> losers;
	private ArrayList<Player> players;
	private DiceCup diceCup;
	private GUI gui;
	
	public Game(GUI gui){
		this.gui        = gui;
		this.board      = new Board();
		this.diceCup    = new DiceCup(new D6(), new D6());
		this.players    = new ArrayList<>();
		this.message    = new Stack<>();
		this.losers     = new ArrayList<>();
	}

	
	public void start(){
		while (!this.checkGameEnd()){
			ArrayList<Player> tempPlayers = (ArrayList<Player>) this.players.clone();

			for (Player player: tempPlayers) {
				this.takeTurn(player);
				this.updateUI();
			}
		}
		this.message.add("YAY player won");
		this.updateUI();
	}

	private void takeTurn(Player player){
		player.takeTurn();
	}

	private void updateUI(){
		this.gui.updateUI(this);
	}

	private boolean checkGameEnd() {
		return this.players.size() == 1;
	}


	public void addMessage (String msg) {
		this.message.add(msg);
	}

	public Stack<String> getMessage() {
		return message;
	}


	public void addLoser(Player loser) {
		this.losers.add(loser);
		this.players.remove(loser);
		loser.getOwns().forEach(Ownable::removeOwner);
	}

	public DiceCup getDiceCup() {
		return diceCup;
	}

	public Board getBoard() {
		return board;
	}

	public boolean addPlayer(String name){
		for (Player player: players) {
			if(Objects.equals(player.getName(), name)){
				return false;
			}
		}

		players.add(new Player(name, this));
		return true;
	}

	public Player getPlayer(String name){
		return players.stream().filter(player -> player.getName().equals(name)).findFirst().get();
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public ArrayList<Player> getLosers() {
		return losers;
	}
}
