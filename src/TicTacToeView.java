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
