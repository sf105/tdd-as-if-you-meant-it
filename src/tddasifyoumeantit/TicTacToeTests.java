package tddasifyoumeantit;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        assertEquals("Unfinished", ticTacToeScoreOf(new Moves()));
        assertEquals("Unfinished", ticTacToeScoreOf(new Moves(1)));
        assertEquals("Unfinished", ticTacToeScoreOf(new Moves(1, 2)));
        assertEquals("Unfinished", ticTacToeScoreOf(new Moves(1, 2, 3)));
        assertEquals("Unfinished", ticTacToeScoreOf(new Moves(1, 2, 3, 4)));
    }
    @Test public void
    xWinsWithAnInitialRow() {
        assertEquals("X", ticTacToeScoreOf(new Moves(1, 4, 2, 5, 3)));
        assertEquals("X", ticTacToeScoreOf(new Moves(4, 1, 5, 2, 6)));
        assertEquals("X", ticTacToeScoreOf(new Moves(7, 4, 8, 5, 9)));
    }

    @Test public void
    oWinsWithTheTopRow() {
        assertEquals("O", ticTacToeScoreOf(new Moves(7, 1, 4, 2, 5, 3)));
        assertEquals("O", ticTacToeScoreOf(new Moves(7, 4, 1, 5, 2, 6)));
        assertEquals("O", ticTacToeScoreOf(new Moves(1, 7, 2, 8, 5, 9)));
    }

    @Test public void
    xWinsWithALaterRow() {
        assertEquals("X", ticTacToeScoreOf(new Moves(7, 8, 1, 4, 2, 5, 3)));
    }

    private String ticTacToeScoreOf(Moves moves) {
        if (moves.hasTooFewMoves()) {  return "Unfinished"; }
        if (moves.is_an_X_row()) {
            return "X";
        }
        if (moves.is_an_O_row()){
            return "O";
        }
        return "Undefined";
    }

    private static class Moves {
        public static final List<Integer> UPPER_ROW = Arrays.asList(1, 2, 3);
        public static final List<Integer> MIDDLE_ROW = Arrays.asList(4, 5, 6);
        public static final List<Integer> LOWER_ROW = Arrays.asList(7, 8, 9);

        private final List<Integer> moves;

        private Moves(Integer... moves) {
            this.moves = Arrays.asList(moves);
        }

        public boolean hasTooFewMoves() {
            return moves.size() < 5;
        }

        private boolean is_an_X_row() {
            return has_a_row(xMoves());
        }

        private boolean is_an_O_row() {
            return has_a_row(oMoves());
        }

        private List<Integer> oMoves() {
            return playerMoves(1);
        }

        private List<Integer> xMoves() {
            return playerMoves(0);
        }

        private List<Integer> playerMoves(int playerOffset) {
            final List<Integer> result = new ArrayList<>();
            for (int i = playerOffset; i < moves.size(); i += 2) {
                result.add(moves.get(i));
            }
            return result;
        }

        private boolean has_a_row(List<Integer> moves) {
            return moves.containsAll(UPPER_ROW)
                    || moves.containsAll(MIDDLE_ROW)
                    || moves.containsAll(LOWER_ROW);
        }
    }
}
