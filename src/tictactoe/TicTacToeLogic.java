package tictactoe;

import common.model.Board;
import common.model.Status;


public class TicTacToeLogic {

    public boolean isValidMove(Board board, int row, int col) {
        if (row < 0 || col < 0 || row >= board.getSizeX() || col >= board.getSizeY()) {
            return false;
        }
        return board.getCells(row, col).isEmpty();
    }


    public boolean  isDraw(Board board){
        return board.isFull();
    }


    public boolean isWinningMove(Board board, int row, int col, Status status) {
        int winRangeScanne = board.getWinRangeScanne(); // Le nombre de cases consécutives nécessaires pour gagner

//        for (int i = 0; i < board.getSize(); i++) {
//            for (int j = 0; j < board.getSize(); j++) {

                // Vérifier la ligne
                if (checkDirection(board, row, col, status, 0, 1, winRangeScanne)) return true; // Horizontal
                // Vérifier la colonne
                if (checkDirection(board, row, col, status, 1, 0, winRangeScanne)) return true; // Vertical
                // Vérifier diagonale principale
                if (checkDirection(board, row, col, status, 1, 1, winRangeScanne)) return true; // Diagonale principale
                // Vérifier diagonale secondaire
                if (checkDirection(board, row, col, status, 1, -1, winRangeScanne)) return true; // Diagonale secondaire

//            }
//
//        }

        return false;
    }

    // Méthode pour vérifier une direction spécifique (horizontal, vertical, diagonale)
    private boolean checkDirection(Board board, int row, int col, Status status, int dRow, int dCol, int winRangeScanne) {
        int count = 1; // La case actuelle compte déjà pour 1

        // Compter les cases dans la direction positive (dRow, dCol)
        for (int k = 1; k < winRangeScanne; k++) {
            int newRow = row + k * dRow;
            int newCol = col + k * dCol;
            if (!board.exist(newRow, newCol) ||
                    !board.getCells(newRow, newCol).getStatus().equals(status)) {
                break;
            }
            count++;
        }

        // Compter les cases dans la direction négative (-dRow, -dCol)
        for (int i = 1; i < winRangeScanne; i++) {
            int newRow = row - i * dRow;
            int newCol = col - i * dCol;
            if (!board.exist(newRow, newCol) ||
                    !board.getCells(newRow, newCol).getStatus().equals(status)) {
                break;
            }
            count++;
        }

        // Vérifier si on a atteint le nombre requis de cases consécutives
        return count >= winRangeScanne;
    }


}
