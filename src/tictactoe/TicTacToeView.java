package tictactoe;

import tictactoe.model.Board;
import tictactoe.model.Player;
import tictactoe.model.InteractionUtilisateur;

public class TicTacToeView {
    private final InteractionUtilisateur interaction;

    public TicTacToeView(InteractionUtilisateur interaction) {
        this.interaction = interaction;
    }

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

    public int menuGameTypeChoice(){
        int gameTypeChoice;
        do {
            System.out.println("Choisissez le type de Partie");
            System.out.println("PVP type : 1");
            System.out.println("PVE type : 2");
            System.out.println("BOT vs BOT type : 3");

            gameTypeChoice = interaction.getIntInput();// Utilise tictactoe.model.InteractionUtilisateur

            if (gameTypeChoice < 1 || gameTypeChoice > 3) {
                System.out.println("Veuillez entrer un chiffre valide (1, 2 ou 3) :");
            }
        } while (gameTypeChoice < 1 || gameTypeChoice > 3);

        return gameTypeChoice;
    }

    public int[] getMove(Player player) {
        System.out.println(player.getStatus() + ", entrez vos coordonnées :");
        System.out.print("Ligne (0 à 2) : ");
        int row = interaction.getIntInput();
        System.out.print("Colonne (0 à 2) : ");
        int col = interaction.getIntInput();
        return new int[]{row, col};
    }


    public void showMessage(String message) {
        System.out.println(message);
    }
}
