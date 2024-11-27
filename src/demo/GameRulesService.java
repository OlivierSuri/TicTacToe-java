package demo;

import tictactoe.model.Board;

public class GameRulesService {

    public static Position getMove(Board board, PosStrategies strategy) {
        int row = strategy.getPosition(board.getSize());
        int col = strategy.getPosition(board.getSize());
        return new Position(row, col);
    }
}
