package gomoku;

import common.model.Player;
import common.model.Board;
import common.model.InteractionUtilisateur;

public class GomokuView {


    private final InteractionUtilisateur interaction;

    public GomokuView(InteractionUtilisateur interaction) {

        this.interaction = interaction;
    }

    public void displayBoard(Board board) {
        int sizeX = board.getSizeX();
        int sizeY = board.getSizeY();
        System.out.println("   " + "-".repeat(sizeX * 6 - 1));
        for (int i = 0; i < sizeX; i++) {
            System.out.print(i + "| ");
            for (int j = 0; j < sizeY; j++) {
                System.out.print(board.getCells(i, j).getRepresentation());
                System.out.print(" | ");
            }
            System.out.println();
            if (i < sizeX - 1) {
                System.out.println("   " + "-".repeat(sizeX * 6 - 1));
            }
        }
        System.out.println("   " + "-".repeat(sizeX * 6 - 1));
    }

    public int menuGameTypeChoice(){
        int gameTypeChoice;
        do {
            System.out.println("Choisissez le type de Partie");
            System.out.println("PVP type : 1");
            System.out.println("PVE type : 2");
            System.out.println("BOT vs BOT type : 3");

            gameTypeChoice = interaction.getIntInput();// Utilise common.model.InteractionUtilisateur

            if (gameTypeChoice < 1 || gameTypeChoice > 3) {
                System.out.println("Veuillez entrer un chiffre valide (1, 2 ou 3) :");
            }
        } while (gameTypeChoice < 1 || gameTypeChoice > 3);

        return gameTypeChoice;
    }

    public int[] getMove(Player Player) {
        System.out.println(Player.getStatus() + ", entrez vos coordonnées :");
        System.out.print("Ligne (0 à 14) : ");
        int row = interaction.getIntInput();
        System.out.print("Colonne (0 à 14) : ");
        int col = interaction.getIntInput();
        return new int[]{row, col};
    }


    public void showMessage(String message) {
        System.out.println(message);
    }
}
