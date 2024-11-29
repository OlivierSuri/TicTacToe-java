package connect4.model;

import common.model.Board;
import tictactoe.model.Status;

import java.util.Random;

public class ArtificialPlayer extends Player {

    private final Random random;

    public ArtificialPlayer(Status status) {
        super(status);
        random = new Random();
    }

    @Override
    public int getMove(Board board) {
        int col;
        do {
            col = random.nextInt(board.getSizeY());
        } while (board.isColumnFull(col));
        return col;
    }
}
