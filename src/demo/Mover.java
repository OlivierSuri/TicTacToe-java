package demo;

import common.model.Board;

public interface Mover {
    Position getMove(Board board);
}
