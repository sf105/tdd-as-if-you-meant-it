package tddasifyoumeantit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("WeakerAccess")
class TicTacToeMoves {
    private static final List<Integer> UPPER_ROW = Arrays.asList(1, 2, 3);
    private static final List<Integer> MIDDLE_ROW = Arrays.asList(4, 5, 6);
    private static final List<Integer> LOWER_ROW = Arrays.asList(7, 8, 9);
    private static final List<Integer> LEFT_COLUMN = Arrays.asList(1, 4, 7);
    private static final int O_OFFSET = 1;
    private static final int X_OFFSET = 0;


    private final List<Integer> moves;

    TicTacToeMoves(Integer... moves) {
        this.moves = Arrays.asList(moves);
    }

    public String score() {
        if (hasTooFewMoves()) {  return "Unfinished"; }
        if (X_wins()) {
            return "X";
        }
        if (O_wins()){
            return "O";
        }
        return "Draw";
    }

    private boolean hasTooFewMoves() {
        return moves.size() < 5;
    }

    private boolean X_wins() {
        return has_won(xMoves());
    }

    private boolean O_wins() {
        return has_won(oMoves());
    }

    private List<Integer> oMoves() {
        return playerMoves(O_OFFSET);
    }

    private List<Integer> xMoves() {
        return playerMoves(X_OFFSET);
    }

    private List<Integer> playerMoves(int playerOffset) {
        final List<Integer> result = new ArrayList<>();
        for (int i = playerOffset; i < moves.size(); i += 2) {
            result.add(moves.get(i));
        }
        return result;
    }

    private boolean has_won(List<Integer> moves) {
        return moves.containsAll(UPPER_ROW)
                || moves.containsAll(MIDDLE_ROW)
                || moves.containsAll(LOWER_ROW)
                || moves.containsAll(LEFT_COLUMN);
    }
}
