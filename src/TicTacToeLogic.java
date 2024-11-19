public class TicTacToeLogic {
    private Board board;

    public TicTacToeLogic(Board board) {
        this.board = board;
    }

    public boolean isValidMove(int row, int col) {
        if (row < 0 || col<0 || row >= board.getSize() || col >= board.getSize()) {
            return false;
        }
        return board.getCell(row, col).isEmpty();
    }

    public boolean isWinningMove(int row, int col, String representation) {
        int size = board.getSize();

        // Vérifier la ligne
        boolean winRow = true;
        for (int j = 0; j < size; j++) {
            if (!board.getCell(row, j).getRepresentation().equals(representation)) {
                winRow = false;
                break;
            }
        }

        // Vérifier la colonne
        boolean winCol = true;
        for (int i = 0; i < size; i++) {
            if (!board.getCell(i, col).getRepresentation().equals(representation)) {
                winCol = false;
                break;
            }
        }

        // Vérifier diagonales
        boolean winDiag1 = true;
        for (int i = 0; i < size; i++) {
            if (!board.getCell(i, i).getRepresentation().equals(representation)) {
                winDiag1 = false;
                break;
            }
        }
        // Vérifier la diagonale secondaire
        boolean winDiag2 = true;
        for (int i = 0; i < size; i++) {
            if (!board.getCell(i, size - 1 - i).getRepresentation().equals(representation)) {
                winDiag2 = false;
                break;
            }
        }
        return winRow || winCol || winDiag1 || winDiag2;
    }
    public boolean  isDraw(){
        return board.isFull();
    }
}
