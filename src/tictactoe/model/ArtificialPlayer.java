package tictactoe.model;

import java.util.Random;

public class ArtificialPlayer extends Player {
    private Random random;

    public ArtificialPlayer(Status representation) {
        super(representation);
        this.random = new Random();
    }

//    @Override
    public int[] getMove(Board board) {
        int row, col;
        do {
            row = random.nextInt(board.getSize());
            col = random.nextInt(board.getSize());
        } while (!board.getCell(row, col).isEmpty());
        return new int[]{row, col};
    }
}
