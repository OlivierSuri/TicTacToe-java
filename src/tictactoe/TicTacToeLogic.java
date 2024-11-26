package tictactoe;

import tictactoe.model.Board;
import tictactoe.model.Status;

public class TicTacToeLogic {
    private Board board;


    public TicTacToeLogic(Board board) {
        this.board = board;
    }

    public boolean isValidMove(int row, int col) {
        if (row < 0 || col < 0 || row >= board.getSize() || col >= board.getSize()) {
            return false;
        }
        return board.getCell(row, col).isEmpty();
    }


    public boolean  isDraw(){
        return board.isFull();
    }


    public boolean isWinningMove(int row, int col, Status status) {
        int winRangeScanne = board.getWinRangeScanne(); // Le nombre de cases consécutives nécessaires pour gagner

        // Vérifier la ligne
        if (checkDirection(row, col, status, 0, 1, winRangeScanne)) return true; // Horizontal
        // Vérifier la colonne
        if (checkDirection(row, col, status, 1, 0, winRangeScanne)) return true; // Vertical
        // Vérifier diagonale principale
        if (checkDirection(row, col, status, 1, 1, winRangeScanne)) return true; // Diagonale principale
        // Vérifier diagonale secondaire
        if (checkDirection(row, col, status, 1, -1, winRangeScanne)) return true; // Diagonale secondaire

        return false;
    }

    // Méthode pour vérifier une direction spécifique (horizontal, vertical, diagonale)
    private boolean checkDirection(int row, int col, Status status, int dRow, int dCol, int winRangeScanne) {
        int count = 1; // La case actuelle compte déjà pour 1

        // Compter les cases dans la direction positive (dRow, dCol)
        for (int i = 1; i < winRangeScanne; i++) {
            int newRow = row + i * dRow;
            int newCol = col + i * dCol;
            if (!board.exist(newRow, newCol) ||
                    !board.getCell(newRow, newCol).getStatus().equals(status)) {
                break;
            }
            count++;
        }

        // Compter les cases dans la direction négative (-dRow, -dCol)
        for (int i = 1; i < winRangeScanne; i++) {
            int newRow = row - i * dRow;
            int newCol = col - i * dCol;
            if (!board.exist(newRow, newCol) ||
                    !board.getCell(newRow, newCol).getStatus().equals(status)) {
                break;
            }
            count++;
        }

        // Vérifier si on a atteint le nombre requis de cases consécutives
        return count >= winRangeScanne;
    }


}
