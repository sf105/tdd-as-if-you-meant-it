package tddasifyoumeantit;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

@SuppressWarnings("WeakerAccess")
class TicTacToeMoves {
    private static final List<List<Integer>> WINNING_PLAYS = asList(
            asList(1, 2, 3), asList(4, 5, 6), asList(7, 8, 9), asList(1, 4, 7));

    public enum Player {
        X(0),
        O(1);

        private final int offset;
        Player(int offset) {
            this.offset = offset;
        }

        private List<Integer> moves(List<Integer> moves) {
            final List<Integer> result = new ArrayList<>();
            for (int i = this.offset; i < moves.size(); i += 2) {
                result.add(moves.get(i));
            }
            return result;
        }
    }

    private final List<Integer> game;

    public TicTacToeMoves(Integer... game) {
        this.game = asList(game);
    }

    public String score() {
        if (hasTooFewMoves()) {  return "Unfinished"; }
        for (Player player : Player.values()) {
            if (playerWins(player)) {
                return player.name();
            }
        }
        return "Draw";
    }

    private boolean hasTooFewMoves() {
        return game.size() < 5;
    }

    private boolean playerWins(Player player) {
        return has_won(player.moves(game));
    }

    private boolean has_won(List<Integer> moves) {
        return WINNING_PLAYS.stream().anyMatch(moves::containsAll);
    }
}
