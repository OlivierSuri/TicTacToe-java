package connect4.model;

import common.model.Board;
import common.model.Status;

public abstract class Player {
    private final Status status;

    public Player(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public abstract int getMove(Board board); // Chaque joueur implémente cette méthode
}
