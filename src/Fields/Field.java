package Fields;
import Game.Game;
import Player.*;


public abstract class Field {

	private String name;
	private String decs;
	private Game game;


	public Field(Game game,String name, String decs){
		this.game = game;
		this.decs = decs;
		this.name = name;
	}


	public void onLand (Player player){
	}

	public String getName() {
		return this.game.getLanguage(this.name);
	}

	public String getDecs() {
		return this.game.getLanguage(this.decs);
	}

	public Game getGame() {
		return this.game;
	}
}