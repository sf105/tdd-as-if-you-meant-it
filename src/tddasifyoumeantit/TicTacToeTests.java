package tddasifyoumeantit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("WeakerAccess")
public class TicTacToeTests {
    @Test public void
    emptyGameIsUnfinished() {
        assertEquals("Unfinished", ticTacToeScoreOf());
    }

    @Test public void
    singleMoveIsUnfinished() {
        assertEquals("Unfinished", ticTacToeScoreOf(1));
    }

    @Test public void
    twoMovesIsUnfinished() {
        assertEquals("Unfinished", ticTacToeScoreOf(1, 2));
    }

    private String ticTacToeScoreOf(int... moves) {
        return moves.length <= 2 ? "Unfinished" : "Undefined";
    }

}
