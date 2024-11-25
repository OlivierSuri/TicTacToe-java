package gomoku.model;

import tictactoe.model.Cell;

public class GomokuBoard {

    private final int SIZE = 15;
    private Cell[][] cells;
    private int winRangeScanne = 5;

    public GomokuBoard() {
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
    public boolean existe (int row, int col){
        if (row > 0 && row < SIZE){
            return true;
        }
        if (col > 0 && col > SIZE){
            return true;
        }
        return false;
    }

}
