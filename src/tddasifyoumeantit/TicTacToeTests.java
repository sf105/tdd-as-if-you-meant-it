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
    xWinsWithAnInitialRow() {
        assertEquals("X", ticTacToeScoreOf(1, 4, 2, 5, 3));
        assertEquals("X", ticTacToeScoreOf(4, 1, 5, 2, 6));
        assertEquals("X", ticTacToeScoreOf(7, 4, 8, 5, 9));
    }
    @Test public void
    oWinsWithTheTopRow() {
        assertEquals("O", ticTacToeScoreOf(7, 1, 4, 2, 5, 3));
        assertEquals("O", ticTacToeScoreOf(7, 4, 1, 5, 2, 6));
        assertEquals("O", ticTacToeScoreOf(1, 7, 2, 8, 5, 9));
    }

    private String ticTacToeScoreOf(int... moves) {
        if (moves.length < 5) {  return "Unfinished"; }
        if (is_an_X_row(moves)) {
            return "X";
        }
        if ((moves[1] == 1 && moves[3] == 2 && moves[5] == 3)
            || (moves[1] == 4 && moves[3] == 5 && moves[5] == 6)
            || (moves[1] == 7 && moves[3] == 8 && moves[5] == 9)){
            return "O";
        }
        return "Undefined";
    }

    private boolean is_an_X_row(int[] moves) {
        return (moves[0] == 1 && moves[2] == 2 && moves[4] == 3)
            || (moves[0] == 4 && moves[2] == 5 && moves[4] == 6)
            || (moves[0] == 7 && moves[2] == 8 && moves[4] == 9);
    }

}
