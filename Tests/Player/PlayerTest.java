package Player;

import Fields.Board;
import Fields.Ownable.Fleet.Fleet;
import Fields.Ownable.Fleet.SecondSail;
import Fields.Ownable.Ownable;
import GUI.DummyGUI;
import Game.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {
	public Game game;
	public Player p1;
	public Player p2;
	public Board board;

	@Before
	public void setUp() throws Exception {
		this.game = new Game(new DummyGUI());
		this.game.addPlayer("P1");
		this.game.addPlayer("P2");
		this.p1 = this.game.getPlayer("P1");
		this.p2 = this.game.getPlayer("P2");
		this.board = this.game.getBoard();
	}

	@After
	public void tearDown() throws Exception {
		this.game = null;
		this.p1 = null;
		this.p2 = null;
		this.board = null;
	}

	@Test
	public void testTryPurchase() throws Exception {
		//Test buy if enough money
		assertThat(p1.tryPurchase((Ownable) board.getFields()[0])).isTrue();
		assertThat(((Ownable)board.getFields()[0]).getOwner()).isEqualTo(p1);

		//Test buy if not enough money
		p1.getAccount().withdraw(28000);
		assertThat(p1.tryPurchase((Ownable) board.getFields()[10])).isFalse();
		assertThat(((Ownable)board.getFields()[10]).getOwner()).isEqualTo(null);
		assertThat(p1.getAccount().getBalance()).isEqualTo(1000);
	}

	@Test
	public void testGetNumOfFieldType() throws Exception {
		assertThat(p1.getNumOfFieldType(SecondSail.class)).isEqualTo(0);

		((Ownable) board.getFields()[17]).setOwner(p1);
		assertThat(p1.getNumOfFieldType(SecondSail.class)).isEqualTo(1);
	}
}