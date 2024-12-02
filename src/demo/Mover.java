package demo;

import model.common.model.Board;

public interface Mover {
    Position getMove(Board board);
}
