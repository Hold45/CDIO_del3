package Fields.Ownable;

import Fields.Field;
import Game.Game;
import Player.Player;

public abstract class Ownable extends Field {
	private Player owner;
	private int price;
	
	public Ownable(Game game,String name, String decs, int price) {
		super(game, name, decs);
		this.price = price;
	}

	public Player getOwner() {
		return owner;
	}

	public void purchase(Player purchaser){
		purchaser.getAccount().withdraw(this.price);
		this.setOwner(purchaser);
	}
	
	public void setOwner(Player owner) {
		this.owner = owner;
		owner.addField(this);
	}

	public void removeOwner(){
		this.owner = null;
	}
	
	public boolean isOwned(){
		return this.owner != null;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public abstract int getRent();
	
	@Override
	public void onLand(Player player){
		if(this.isOwned()){
			if(this.owner == player){
				player.getGame().addMessage("ALREADYOWNS", super.getName());
			}else{
				player.getGame().addMessage("RENTSPACE", super.getName(), Integer.toString(this.getRent()));
				player.getAccount().transfer(this.getOwner().getAccount(), this.getRent());
			}
		}
		else{
			if(player.tryPurchase(this)){
				player.getGame().addMessage("BUYSPACE", super.getName(),Integer.toString(this.getPrice()));
			}
			else{
				player.getGame().addMessage("DONTBUY", super.getName());
			}
		}
	}

}
