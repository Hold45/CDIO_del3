package Fields;

import GUI.DummyGUI;
import Game.Game;
import Player.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class BoardTest {
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
	public void testMove() throws Exception {
		board.move(p1,21);
		assertThat(p1.getPosition()).isEqualTo(0);

		board.move(p1, 20);
		assertThat(p1.getPosition()).isEqualTo(20);
	}
}