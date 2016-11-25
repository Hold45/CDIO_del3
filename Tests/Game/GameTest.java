package Game;

import Fields.Board;
import Fields.Ownable.Ownable;
import GUI.DummyGUI;
import Player.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
	public Game game;
	public Board board;

	@Before
	public void setUp() throws Exception {
		this.game = new Game(new DummyGUI());
		this.board = this.game.getBoard();
	}

	@After
	public void tearDown() throws Exception {
		this.game = null;
		this.board = null;
	}

	@Test
	public void addLoser() throws Exception {
		game.addPlayer("P1");
		Player p1 = game.getPlayer("P1");
		((Ownable) board.getFields()[0]).setOwner(p1);

		game.addLoser(p1);
		assertThat(game.getPlayers()).doesNotContain(p1);
		assertThat(game.getLosers()).contains(p1);
		assertThat(((Ownable) board.getFields()[0]).getOwner()).isNull();
	}

	@Test
	public void testAddPlayer() throws Exception {
		//add player without errors
		assertThat(game.addPlayer("P1")).isTrue();
		assertThat(game.getPlayer("P1").getName()).isEqualTo("P1");

		//Add player with exsisting name.
		assertThat(game.addPlayer("P1")).isFalse();
	}

	@Test
	public void getLanguage() throws Exception {
		assertThat(game.getLanguage("TRIBEENCAMPMENTNAME")).isEqualTo("Tribe Encampment");
	}

	@Test
	public void testRunGame() throws Exception{
		for (int i = 0; i < 1000; i++) {
			game = new Game(new DummyGUI());
			game.addPlayer("P1");
			game.addPlayer("P2");
			game.addPlayer("P3");
			game.start();
			game = null;
		}

	}

}