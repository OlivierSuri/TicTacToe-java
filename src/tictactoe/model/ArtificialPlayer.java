package tictactoe.model;

import common.model.Board;

import java.util.Random;

public class ArtificialPlayer extends Player {
    private Random random;

    public ArtificialPlayer(Status representation) {
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
