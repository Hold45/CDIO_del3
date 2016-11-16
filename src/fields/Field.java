package fields;
import player.*;


public abstract class Field {

	private String name;
	private String decs;
	private String onLandText;
	
	
	public Field(String name, String decs, String onLandText){
		this.decs = decs;
		this.name = name;
		this.onLandText = onLandText;
		
	}
		

	public void onLand (Player player){
		player.getGame().addMessage(this.onLandText);
		
	}

	public String getName() {
		return name;
	}

	public String getDecs() {
		return decs;
	}

	
	
}
