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
        assertEquals("Unfinished", ticTacToeScoreOf());
        assertEquals("Unfinished", ticTacToeScoreOf(1));
        assertEquals("Unfinished", ticTacToeScoreOf(1, 2));
        assertEquals("Unfinished", ticTacToeScoreOf(1, 2, 3));
        assertEquals("Unfinished", ticTacToeScoreOf(1, 2, 3, 4));
    }

    @Test public void
    xWinsWithTheTopRow() {
        assertEquals("X", ticTacToeScoreOf(1, 4, 2, 5, 3));
    }

    private String ticTacToeScoreOf(int... moves) {
        return moves.length < 5 ? "Unfinished" : "Undefined";
    }

}
