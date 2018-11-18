package tddasifyoumeantit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        assertEquals("Unfinished", new TicTacToeMoves().score());
        assertEquals("Unfinished", new TicTacToeMoves(1).score());
        assertEquals("Unfinished", new TicTacToeMoves(1, 2).score());
        assertEquals("Unfinished", new TicTacToeMoves(1, 2, 3).score());
        assertEquals("Unfinished", new TicTacToeMoves(1, 2, 3, 4).score());
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
    xWinsWithALaterRow() {
        assertEquals("X", new TicTacToeMoves(7, 8, 1, 4, 2, 5, 3).score());
    }

    @Test public void
    winningWithAColumn() {
        assertEquals("X", new TicTacToeMoves(3, 4, 1, 2, 4, 6, 7).score());
        assertEquals("O", new TicTacToeMoves(8, 3, 4, 1, 2, 4, 6, 7).score());
    }

    @Test public void
    noWinsIsADraw() {
        assertEquals("Draw", new TicTacToeMoves(1, 2, 3, 4, 5, 6, 7, 8, 9).score());
    }

}
