package Player;

import Fields.Board;
import GUI.DummyGUI;
import Game.Game;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountTest {
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
	public void testTransfer() throws Exception {
		p1.getAccount().transfer(p2.getAccount(), 1000);
		assertThat(p1.getAccount().getBalance()).isEqualTo(29000);
		assertThat(p2.getAccount().getBalance()).isEqualTo(31000);

	}

	@Test
	public void testWithdraw() throws Exception {
		//Withdraw 2000
		assertThat(p1.getAccount().withdraw(2000)).isEqualTo(2000);
		assertThat(p1.getAccount().getBalance()).isEqualTo(28000);

		//Withdraw too much
		assertThat(p1.getAccount().withdraw(29000)).isEqualTo(28000);
		assertThat(p1.getAccount().getBalance()).isEqualTo(0);
		assertThat(game.getLosers()).contains(p1);

	}

}