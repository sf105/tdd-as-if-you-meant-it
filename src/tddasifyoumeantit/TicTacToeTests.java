package tddasifyoumeantit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    private String ticTacToeScoreOf(int... moves) {
        return moves.length <= 2 ? "Unfinished" : "Undefined";
    }

}
