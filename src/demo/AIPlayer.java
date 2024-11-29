package demo;

import common.model.Board;

public class AIPlayer extends Player {

    AIPlayer() {
        super(PosStrategies.AI);
    }

    @Override
    public Position getMove(Board board) {
        Position pos = super.getMove(board);
        while(testPos(board, pos)<50){
            pos = super.getMove(board);
        }
        return pos;
    }

    private int testPos(Board board, Position pos) {
        int score = 60;
        return score;// à calculer
    }

}
