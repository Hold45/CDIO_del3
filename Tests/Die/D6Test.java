package Die;

import Die.Die;import org.junit.Test;
import static org.assertj.core.api.Assertions.*;


public class D6Test {

	/**
	 * Test if roll is between 1 and 6.
	 *
	 * @throws Exception
	 */
	@Test
	public void testRollBetween1To6() throws Exception {
		Die die = new D6();
		for (int i = 0; i < 10000; i++)
			assertThat(die.roll()).isBetween(1,6);
	}


	/**
	 * Test if the occurrences of 1-6 on the d6 is truly random
	 *
	 * @throws Exception
	 */
	@Test
	public void testRollOccurrences() throws Exception {
		Die die = new D6();

		int rolls = 60000;
		int[] num = {0,0,0,0,0,0};
		
		for (int i = 0; i < rolls; i++)
			num[die.roll()-1]++;

		for (int i = 0; i < num.length; i++)
			assertThat(num[i]).as("%s = %s",i,num[i]).isBetween(9600, 10400);
	}
}