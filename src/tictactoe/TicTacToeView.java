package tictactoe;

import tictactoe.model.Board;
import tictactoe.model.Player;

public class TicTacToeView {



    public void displayBoard(Board board) {
        int size = board.getSize();
        System.out.println(" " + "-".repeat(size * 6 - 1));
        for (int i = 0; i < size; i++) {
            System.out.print("| ");
            for (int j = 0; j < size; j++) {
                System.out.print(board.getCell(i, j).getRepresentation());
                System.out.print(" | ");
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println(" " + "-".repeat(size * 6 - 1));
            }
        }
        System.out.println(" " + "-".repeat(size * 6 - 1));
    }

    public void displayMenuGameTypeChoice(){

            System.out.println("Choisissez le type de Partie");
            System.out.println("PVP type : 1");
            System.out.println("PVE type : 2");
            System.out.println("BOT vs BOT type : 3");

    }

    public void displayPlayerMoveMenu(Player player) {
        System.out.println(player.getStatus() + ", entrez vos coordonnées :");
        System.out.println("Ligne (0 à 2) : ");
        System.out.println("Colonne (0 à 2) : ");
    }


    public void showMessage(String message) {
        System.out.println(message);
    }
}
