package tictactoe.model;

public abstract class Player {
    Status status;

    public Player(Status status) {
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
