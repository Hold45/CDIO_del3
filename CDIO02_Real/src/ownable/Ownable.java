package ownable;

import fields.Field;
import player.Account;
import player.Player;

public abstract class Ownable extends Field {
	private Player owner;
	private boolean owned = false;
	private int price;
	
	public Ownable(String name, String decs, String onLandText, int price) {
		super(name, decs, onLandText);
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
		this.owned = true;
		owner.addField(this);
	}
	
	public boolean isOwned(){
		return this.owned;
	}
	
	public int getPrice(){
		return this.price;
	}
	
	public abstract int getRent();
	
	@Override
	public void onLand(Player player){
		super.onLand(player);
		
		if(this.isOwned()){
			player.getAccount().transfer(this.getOwner().getAccount(), this.getRent());
		}
		else{
			player.tryPurchase(this);
		}
	}
	
}
