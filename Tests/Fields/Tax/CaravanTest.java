package Fields.Tax;

import Fields.Board;
import Fields.Ownable.Ownable;
import GUI.DummyGUI;
import Game.Game;
import Player.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class CaravanTest {
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
	public void testTax() throws Exception{
		//Test tax 10%.
		board.move(p1,16);
		assertThat(p1.getAccount().getBalance()).isEqualTo(30000-3000);

		//Test field increase total assets.
		((Ownable)board.getFields()[0]).setOwner(p1);
		p1.getAccount().deposit(3000);
		board.move(p1,0);
		assertThat(p1.getAccount().getBalance()).isEqualTo(30000-3100);

		//Test when 10% of total assets exceeds 4000.
		((Ownable)board.getFields()[10]).setOwner(p1);
		((Ownable)board.getFields()[9]).setOwner(p1);
		p1.getAccount().deposit(3100);
		board.move(p1,0);
		assertThat(p1.getAccount().getBalance()).isEqualTo(30000-4000);
	}


}