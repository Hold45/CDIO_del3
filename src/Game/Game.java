package Game;
import Die.D6;
import Die.DiceCup;
import Fields.*;
import Fields.Ownable.*;
import Player.Player;
import GUI.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Stack;

public class Game {

	private Board board;

	private Stack<String> message;
	private ArrayList<Player> losers;
	private ArrayList<Player> players;
	private DiceCup diceCup;
	private GUI gui;
	private ResourceBundle language;

	public Game(GUI gui){
		this.gui        = gui;
		this.board      = new Board(this);
		this.diceCup    = new DiceCup(new D6(), new D6());
		this.players    = new ArrayList<>();
		this.message    = new Stack<>();
		this.losers     = new ArrayList<>();
		this.language   = GUI.language;
	}


	public void start(){
		while (!this.checkGameEnd()){
			ArrayList<Player> tempPlayers = (ArrayList<Player>) this.players.clone();

			for (Player player: tempPlayers) {
				this.takeTurn(player);

				if(this.checkGameEnd()){
					this.updateUI();
					break;
				}
				this.updateUI();
			}
		}
		this.addMessage("WIN",this.players.get(0).getName());
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


	public void addMessage (String msg, String... args) {
		this.message.add(String.format(language.getString(msg), args));
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
			if(Objects.equals(player.getName().toUpperCase(), name.toUpperCase())){
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

	public String getLanguage(String text) {
		return language.getString(text);
	}
}