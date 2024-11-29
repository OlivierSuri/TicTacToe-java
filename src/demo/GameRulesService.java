package demo;

import common.model.Board;

public class GameRulesService {

    public static Position getMove(Board board, PosStrategies strategy) {
        int row = strategy.getPosition(board.getSizeX());
        int col = strategy.getPosition(board.getSizeY());
        return new Position(row, col);
    }
}
