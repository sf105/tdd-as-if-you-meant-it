package tddasifyoumeantit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static tddasifyoumeantit.TicTacToeMoves.RESULT_DRAW;
import static tddasifyoumeantit.TicTacToeMoves.RESULT_UNFINISHED;

/*
   This represents the positions in a game.
   'X' always starts a game, and players alternate
      1 | 2 | 3
      4 | 5 | 6
      7 | 8 | 9
 */

@SuppressWarnings("WeakerAccess")
public class TicTacToeTests {
    @Test public void
    aGameWithFewerThan5MovesCannotBeFinished() {
        assertEquals(RESULT_UNFINISHED, new TicTacToeMoves().score());
        assertEquals(RESULT_UNFINISHED, new TicTacToeMoves(1).score());
        assertEquals(RESULT_UNFINISHED, new TicTacToeMoves(1, 2).score());
        assertEquals(RESULT_UNFINISHED, new TicTacToeMoves(1, 2, 3).score());
        assertEquals(RESULT_UNFINISHED, new TicTacToeMoves(1, 2, 3, 4).score());
    }
    @Test public void
    xWinsWithAnInitialRow() {
        assertEquals("X", new TicTacToeMoves(1, 4, 2, 5, 3).score());
        assertEquals("X", new TicTacToeMoves(4, 1, 5, 2, 6).score());
        assertEquals("X", new TicTacToeMoves(7, 4, 8, 5, 9).score());
    }

    @Test public void
    oWinsWithTheTopRow() {
        assertEquals("O", new TicTacToeMoves(7, 1, 4, 2, 5, 3).score());
        assertEquals("O", new TicTacToeMoves(7, 4, 1, 5, 2, 6).score());
        assertEquals("O", new TicTacToeMoves(1, 7, 2, 8, 5, 9).score());
    }

    @Test public void
    winningWithALaterRow() {
        assertEquals("X", new TicTacToeMoves(7, 8, 1, 4, 2, 5, 3).score());
        assertEquals("O", new TicTacToeMoves(9, 7, 8, 1, 4, 2, 5, 3).score());
    }

    @Test public void
    winningWithAColumn() {
        assertEquals("X", new TicTacToeMoves(3, 4, 1, 2, 4, 6, 7).score());
        assertEquals("O", new TicTacToeMoves(8, 3, 4, 1, 2, 4, 6, 7).score());

        assertEquals("X", new TicTacToeMoves(1, 2, 4, 5, 7).score());
        assertEquals("X", new TicTacToeMoves(2, 4, 5, 7, 8).score());
        assertEquals("X", new TicTacToeMoves(3, 4, 6, 7, 9).score());
    }

    @Test public void
    winningWith_a_diagonal() {
        assertEquals("X", new TicTacToeMoves(1, 2, 5, 4, 9).score());
        assertEquals("X", new TicTacToeMoves(7, 2, 5, 4, 3).score());
        assertEquals("O", new TicTacToeMoves(7, 1, 2, 5, 4, 9).score());
        assertEquals("O", new TicTacToeMoves(9, 7, 2, 5, 4, 3).score());
    }

    @Test public void
    noWinsIsADraw() {
        assertEquals(RESULT_DRAW, new TicTacToeMoves(
                1, 5,
                2, 3,
                6, 4,
                8, 9,
                7).score());
    }

}
