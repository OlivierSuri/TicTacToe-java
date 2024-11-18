public class TicTacToe {
    private final int SIZE = 3;
    private Cell[][] board;

    public TicTacToe() {
        this.board = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell(); // Initialisation avec une cellule vide
            }
        }
    }

    public void display() {
        System.out.println(" " + "-".repeat(SIZE * 6 - 1));
        for (int i = 0; i < SIZE; i++) {

            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j].getRepresentation());
                    System.out.print(" | ");
            }
            System.out.println(" ");

            if (i < SIZE - 1) {
                System.out.println(" " + "-".repeat(SIZE * 6 - 1));
            }
        }
        System.out.println(" " + "-".repeat(SIZE * 6 - 1));
    }
}
