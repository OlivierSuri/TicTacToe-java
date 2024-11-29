package gomoku.model;

import common.model.Board;
import tictactoe.model.Status;

import java.util.Random;

public class GomokuArtificialPlayer extends GomokuPlayer {

    private Random random;

    public GomokuArtificialPlayer(Status representation) {
        super(representation);
        this.random = new Random();
    }

    @Override
    public int[] getMove(Board board) {
        int row, col;
        do {
            row = random.nextInt(board.getSizeX());
            col = random.nextInt(board.getSizeY());
        } while (!board.getCells(row, col).isEmpty());
        return new int[]{row, col};
    }
}
