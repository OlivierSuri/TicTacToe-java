package gomoku.model;

import tictactoe.model.Status;

import java.util.Random;

public class GomokuArtificialPlayer extends GomokuPlayer {

    private Random random;

    public GomokuArtificialPlayer(Status representation) {
        super(representation);
        this.random = new Random();
    }

    @Override
    public int[] getMove(GomokuBoard board) {
        int row, col;
        do {
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
        } while (!board.getCell(row, col).isEmpty());
        return new int[]{row, col};
    }
}
