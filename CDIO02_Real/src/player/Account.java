package player;

public class Account {
	private int balance;
	private Player owner;
	
	public Account(Player player){
		this.balance= 30000;
		this.owner = player;
	}
	
	public int getBalance(){
		return balance;
		
	}
	
	
	public void transfer(Account transferTo, int payment){
		transferTo.deposit(this.withdraw(payment));
	}
	
	public void deposit(int value){
		balance += value;
	}
	
	public int withdraw(int value){
		if (value>balance){
			int beforeWithdraw = this.getBalance();
			
			this.owner.getGame().addLoser(this.owner);
			this.balance = 0;
			return beforeWithdraw;
		}
		else {
			this.balance -= value;
			return value;
		}
	}

	public Player getOwner() {
		return owner;
	}
}