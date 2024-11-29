package common.model;

public class Board {
    private final int sizeX;
    private final int sizeY;
    private Cell[][] cells;
    private int winRangeScanne;

    public Board(int sizeX, int sizeY, int winRangeScanne) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.winRangeScanne = winRangeScanne;
        cells = new Cell[sizeX][sizeY];
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                cells [i][j] = new Cell();
            }
        }
    }

    public boolean isFull() {
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                if (cells[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean exist(int row, int col){
        if (row >= 0 && row < sizeX && col >= 0 && col < sizeY) {
            return true;
        }
        return false;
    }

    public boolean isColumnFull(int col) {
        return !cells[0][col].isEmpty(); // Si la première case de la colonne est occupée
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }
    public Cell getCells(int row, int col) {
        return cells[row][col];
    }

    public int getWinRangeScanne() {
        return winRangeScanne;
    }

}
