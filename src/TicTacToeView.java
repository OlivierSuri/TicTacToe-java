import java.util.Scanner;

public class TicTacToeView {
    private Scanner scanner = new Scanner(System.in);

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

            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un chiffre valide (1, 2 ou 3) :");
                scanner.next();
            }

            gameTypeChoice = scanner.nextInt();
        } while (gameTypeChoice < 1 || gameTypeChoice > 3);

        return gameTypeChoice;
    }

    public int[] getMove(Player player) {
        System.out.println(player.getRepresentation() + ", entrez vos coordonnées :");
        int[] move = new int[2];
        System.out.print("Ligne (0 à 2) : ");
        move[0] = scanner.nextInt();
        System.out.print("Colonne (0 à 2) : ");
        move[1] = scanner.nextInt();
        return move;
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
