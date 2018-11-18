package tddasifyoumeantit;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@SuppressWarnings("WeakerAccess")
class TicTacToeMoves {
    private static final List<List<Integer>> WINNING_PLAYS = asList(
            asList(1, 2, 3), asList(4, 5, 6), asList(7, 8, 9), asList(1, 4, 7));

    public static final Player O_PLAYER = new Player(1);
    public static final Player X_PLAYER = new Player(0);

    private final List<Integer> moves;

    public TicTacToeMoves(Integer... moves) {
        this.moves = asList(moves);
    }

    public String score() {
        if (hasTooFewMoves()) {  return "Unfinished"; }
        if (playerWins(X_PLAYER)) {
            return "X";
        }
        if (playerWins(O_PLAYER)){
            return "O";
        }
        return "Draw";
    }

    private boolean hasTooFewMoves() {
        return moves.size() < 5;
    }

    private boolean playerWins(Player player) {
        return has_won(playerMoves(player.getPlayerOffset()));
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

    private static class Player {
        private final int playerOffset;

        private Player(int playerOffset) {
            this.playerOffset = playerOffset;
        }

        public int getPlayerOffset() {
            return playerOffset;
        }
    }
}
