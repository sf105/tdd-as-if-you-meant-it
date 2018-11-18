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
        assertEquals("Unfinished", new Moves().score());
        assertEquals("Unfinished", new Moves(1).score());
        assertEquals("Unfinished", new Moves(1, 2).score());
        assertEquals("Unfinished", new Moves(1, 2, 3).score());
        assertEquals("Unfinished", new Moves(1, 2, 3, 4).score());
    }
    @Test public void
    xWinsWithAnInitialRow() {
        assertEquals("X", new Moves(1, 4, 2, 5, 3).score());
        assertEquals("X", new Moves(4, 1, 5, 2, 6).score());
        assertEquals("X", new Moves(7, 4, 8, 5, 9).score());
    }

    @Test public void
    oWinsWithTheTopRow() {
        assertEquals("O", new Moves(7, 1, 4, 2, 5, 3).score());
        assertEquals("O", new Moves(7, 4, 1, 5, 2, 6).score());
        assertEquals("O", new Moves(1, 7, 2, 8, 5, 9).score());
    }

    @Test public void
    xWinsWithALaterRow() {
        assertEquals("X", new Moves(7, 8, 1, 4, 2, 5, 3).score());
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

        public String score() {
            if (hasTooFewMoves()) {  return "Unfinished"; }
            if (is_an_X_row()) {
                return "X";
            }
            if (is_an_O_row()){
                return "O";
            }
            return "Undefined";
        }
    }
}
