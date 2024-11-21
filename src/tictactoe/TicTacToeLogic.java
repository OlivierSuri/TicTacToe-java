package tictactoe;

import tictactoe.model.Board;
import tictactoe.model.Status;

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

    public boolean isWinningMove(int row, int col, Status status) {
        int size = board.getSize();

        // Vérifier la ligne
        boolean winRow = true;
        for (int j = 0; j < size; j++) {
            if (!board.getCell(row, j).getStatus().equals(status)) {
                winRow = false;
                break;
            }
        }

        // Vérifier la colonne
        boolean winCol = true;
        for (int i = 0; i < size; i++) {
            if (!board.getCell(i, col).getStatus().equals(status)) {
                winCol = false;
                break;
            }
        }

        // Vérifier diagonales
        boolean winDiag1 = true;
        for (int i = 0; i < size; i++) {
            if (!board.getCell(i, i).getStatus().equals(status)) {
                winDiag1 = false;
                break;
            }
        }
        // Vérifier la diagonale secondaire
        boolean winDiag2 = true;
        for (int i = 0; i < size; i++) {
            if (!board.getCell(i, size - 1 - i).getStatus().equals(status)) {
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
