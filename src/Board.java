public class Board {
    private final int SIZE = 3;
    private Cell[][] cells;

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
}
