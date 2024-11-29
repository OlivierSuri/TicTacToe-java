package gomoku.model;

import common.model.Board;
import common.model.Status;

public abstract class GomokuPlayer {

    Status status;

    public GomokuPlayer(Status status) {
        this.status = status;
    }

    public String getRepresentation() {
        return status.getValue();
    }
    public Status getStatus() {
        return status;
    }
    public String toString() {
        return getRepresentation();
    }

    // Méthode abstraite à implémenter dans les sous-classes
    public abstract int[] getMove(Board board);
}
