package demo;

import tictactoe.model.Board;

public interface Mover {
    Position getMove(Board board);
}
