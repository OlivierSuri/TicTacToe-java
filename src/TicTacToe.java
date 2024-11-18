public class TicTacToe {
    private final int SIZE = 3;
    private Cell[][] board;

    public TicTacToe() {
        this.board = new Cell[SIZE][SIZE];
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            // Affiche une ligne du tableau avec | au début et à la fin
            System.out.print("| "); // Barre verticale au début
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j].getRepresentation()); // Affiche le contenu de la cellule
                if (j < SIZE - 1) {
                    System.out.print(" | "); // Séparateur vertical entre colonnes
                }
            }
            System.out.println(" |"); // Barre verticale à la fin

            // Ligne horizontale après chaque ligne (sauf la dernière)
            if (i < SIZE - 1) {
                System.out.println(" " + "-".repeat(SIZE * 7 - 1));
            }
        }
    }
}
