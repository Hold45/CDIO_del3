package Die;

import Die.DiceCup;import Die.Die;import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


public class DiceCupTest {
	public DiceCup diceCup;

	@Before
	public void setup() throws Exception{
		this.diceCup = new DiceCup(new Die[]{new D6(), new D6()}).roll();
	}

	@After
	public void after() throws Exception{
		this.diceCup = null;
	}

	/**
	 * Check if the two dice values are equal to the get values, value.
	 * @throws Exception
	 */
	@Test
	public void testGetValues() throws Exception {
		assertThat(diceCup.getDice()[0].getValue()).isEqualTo(diceCup.getValues()[0]);
		assertThat(diceCup.getDice()[1].getValue()).isEqualTo(diceCup.getValues()[1]);
	}

	@Test
	public void testGetSum() throws Exception {
		assertThat(Stream.of(diceCup.getDice()).mapToInt(Die::getValue).sum()).isEqualTo(diceCup.getSum());
	}
}