package tictactoe.model;

public class Cell {

    private Status status;

    public Cell() {
        this.status = Status.EMPTY;
    }

    public String getRepresentation() {
        return this.status.getValue();
    }

    public Status getStatus() {
        return this.status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public String toString() {
        return getRepresentation();
    }

    public boolean isEmpty() {
        return status == Status.EMPTY;
    }

}
