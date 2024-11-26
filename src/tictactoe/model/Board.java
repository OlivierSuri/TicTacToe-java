package tictactoe.model;

public class Board {
    private final int SIZE = 3;
    private Cell[][] cells;
    private int winRangeScanne = 3;


    public Board() {
        cells = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public int getSize() {
        return SIZE;
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public int getWinRangeScanne() {
        return winRangeScanne;
    }

    public boolean isFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean exist(int row, int col){
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE) {
            return true;
        }
        return false;
    }
}
