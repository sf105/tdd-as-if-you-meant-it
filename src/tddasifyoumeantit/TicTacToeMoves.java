package tddasifyoumeantit;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@SuppressWarnings("WeakerAccess")
class TicTacToeMoves {
    private static final List<List<Integer>> WINNING_PLAYS = asList(
            asList(1, 2, 3), asList(4, 5, 6), asList(7, 8, 9), asList(1, 4, 7));

    private static final int O_OFFSET = 1;
    private static final int X_OFFSET = 0;


    private final List<Integer> moves;

    TicTacToeMoves(Integer... moves) {
        this.moves = asList(moves);
    }

    public String score() {
        if (hasTooFewMoves()) {  return "Unfinished"; }
        if (playerWins(X_OFFSET)) {
            return "X";
        }
        if (playerWins(O_OFFSET)){
            return "O";
        }
        return "Draw";
    }

    private boolean hasTooFewMoves() {
        return moves.size() < 5;
    }

    private boolean playerWins(int playerOffset) {
        return has_won(playerMoves(playerOffset));
    }

    private List<Integer> playerMoves(int playerOffset) {
        final List<Integer> result = new ArrayList<>();
        for (int i = playerOffset; i < moves.size(); i += 2) {
            result.add(moves.get(i));
        }
        return result;
    }

    private boolean has_won(List<Integer> moves) {
        return WINNING_PLAYS.stream().anyMatch(moves::containsAll);
    }
}
