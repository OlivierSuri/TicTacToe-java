package view.view;

import model.common.model.Board;
import model.common.model.Player;

public class View {


    public void displayBoard(Board board) {

        int sizeX = board.getSizeX();
        int sizeY = board.getSizeY();
        int cellWidth = board.getCellWidth();
        System.out.println(" " + "-".repeat(sizeX * cellWidth - 1));
        for (int i = 0; i < sizeX; i++) {
            System.out.print("| ");
            for (int j = 0; j < sizeY; j++) {
                System.out.print(board.getCells(i, j).getRepresentation());
                System.out.print(" | ");
            }
            System.out.println();
            if (i < sizeX - 1) {
                System.out.println(" " + "-".repeat(sizeX * cellWidth - 1));
            }
        }
        System.out.println(" " + "-".repeat(sizeX * cellWidth - 1));
    }


    public void displayMenuGameTypeChoice(){

        System.out.println("Choisissez le type de Partie");
        System.out.println("PVP type : 1");
        System.out.println("PVE type : 2");
        System.out.println("BOT vs BOT type : 3");

    }

    public void displayPlayerMoveMenu(String status) {
        System.out.println(status + ", entrez vos coordonnées :");
        System.out.println("Ligne (0 à 2) : ");
        System.out.println("Colonne (0 à 2) : ");
    }

    private void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }



    public void showMessage(String message) {
        System.out.println(message);
    }
}
