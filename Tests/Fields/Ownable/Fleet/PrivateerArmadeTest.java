package Fields.Ownable.Fleet;

import Fields.Board;
import Fields.Ownable.Ownable;
import GUI.DummyGUI;
import Game.Game;
import Player.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import static org.junit.Assert.*;

public class PrivateerArmadeTest {

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
	public void testBuy() throws Exception{
		this.board.move(this.p1, 17);
		assertThat(((Ownable)this.board.getFields()[17]).getOwner()).isEqualTo(this.p1);
	}

	@Test
	public void testRent() throws Exception{
		((Ownable)board.getFields()[17]).setOwner(p2);
		board.move(p1,17);
		assertThat(p1.getAccount().getBalance()).isEqualTo(29500);

		((Ownable)board.getFields()[18]).setOwner(p2);
		((Ownable)board.getFields()[19]).setOwner(p2);
		board.move(p1,1);

		assertThat(p1.getAccount().getBalance()).isEqualTo(27500);
	}

}