package Die;

import java.util.Random;


public abstract class Die{
	private int value;
	private int sides;
	
	Die(int sides){
		this.sides = sides;
	}
	
	public int roll() {
		Random random = new Random();
		this.value = random.nextInt(sides)+1;
		return this.value;
	}
	public int getValue() {
		return value;
	}

}