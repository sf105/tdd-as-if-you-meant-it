package tddasifyoumeantit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("WeakerAccess")
class TicTacToeMoves {
    private static final List<Integer> UPPER_ROW = Arrays.asList(1, 2, 3);
    private static final List<Integer> MIDDLE_ROW = Arrays.asList(4, 5, 6);
    private static final List<Integer> LOWER_ROW = Arrays.asList(7, 8, 9);

    private final List<Integer> moves;

    TicTacToeMoves(Integer... moves) {
        this.moves = Arrays.asList(moves);
    }

    private boolean hasTooFewMoves() {
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
