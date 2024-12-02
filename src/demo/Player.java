package demo;

import model.common.model.Board;

public class Player implements Mover{

    private PosStrategies strategy;

    Player(PosStrategies posStrategies) {
        this.strategy = posStrategies;
    }

    @Override
    public Position getMove(Board board) {
        if(board != null){
            int row = this.strategy.getPosition(board.getSizeX());
            int col = this.strategy.getPosition(board.getSizeY());
            return new Position(row, col);
        } else {
            return new Position(-1, -1);
        }
    }

    public void changeStrategy(PosStrategies posStrategies) {
        this.strategy = posStrategies;
    }

    public PosStrategies getStrategy() {
        return this.strategy;
    }
}
