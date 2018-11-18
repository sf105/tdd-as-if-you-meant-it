package tddasifyoumeantit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings("WeakerAccess")
public class TicTacToeTests {
    @Test public void
    emptyGameIsUnfinished() {
        assertEquals("Unfinished", new int[0]);
    }

}
