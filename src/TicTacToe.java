import java.util.Scanner;

public class TicTacToe {
    private final int SIZE = 3;
    private Cell[][] board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public TicTacToe() {
        this.player1 = new Player(" X ");
        this.player2 = new Player(" O ");
        this.currentPlayer = player1;

        //init board
        this.board = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell(); // Initialisation avec une cellule vide
            }
        }
        startGame();
    }
    private void startGame() {
        boolean gameOngoing = true;
        while (gameOngoing) {
            //afficher le plateau
            display();
            //faire jouer le joueur
            playRound();
            //joueur suivant
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    private void playRound(){
        boolean validMove = false;
        //Menu de demande de coordonnée de la case
        while (!validMove) {
            // Obtenir un coup valide de l'utilisateur
            int[] move = getMoveFromPlayer();

            // Tenter de placer le symbole sur le plateau
            validMove = setOwner(move[0], move[1], currentPlayer);
            if (!validMove) {
                System.out.println("Mouvement invalide. Essayez encore.");
            }
        }
    }
    // Obtenir un mouvement valide du joueur
    private int[] getMoveFromPlayer() {
        Scanner scanner = new Scanner(System.in);
        int[] move = new int[2];

        while (true) {
            System.out.println(currentPlayer.getName() + ", entrez vos coordonnées :");

            System.out.print("Numéro de ligne (0 à 2) : ");
            if (!scanner.hasNextInt()) {
                System.out.println("Entrée invalide, entrez un nombre entier.");
                scanner.next(); // Consommer l'entrée invalide
                continue;
            }
            move[0] = scanner.nextInt();

            System.out.print("Numéro de colonne (0 à 2) : ");
            if (!scanner.hasNextInt()) {
                System.out.println("Entrée invalide, entrez un nombre entier.");
                scanner.next(); // Consommer l'entrée invalide
                continue;
            }
            move[1] = scanner.nextInt();

            // Vérifier si les coordonnées sont dans les limites
            if (move[0] < 0 || move[0] >= SIZE || move[1] < 0 || move[1] >= SIZE) {
                System.out.println("Les coordonnées doivent être entre 0 et 2. Essayez encore.");
                continue;
            }

            break; // Si tout est valide, on sort de la boucle
        }

        return move;
    }

    // Affecter une cellule au joueur si possible
    private boolean setOwner(int row, int col, Player player) {
        // Vérifier si la cellule est déjà occupée
        if (!board[row][col].getRepresentation().equals("   ")) {
            System.out.println("Cette case est déjà occupée.");
            return false;
        }

        // Affecter la cellule avec le symbole du joueur
        board[row][col].setRepresentation(player.getRepresentation());
        return true;
    }


    // Afficher le plateau
    public void display() {
        System.out.println(" " + "-".repeat(SIZE * 6 - 1));
        for (int i = 0; i < SIZE; i++) {
            System.out.print("| ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j].getRepresentation());
                System.out.print(" | ");
            }
            System.out.println();
            if (i < SIZE - 1) {
                System.out.println(" " + "-".repeat(SIZE * 6 - 1));
            }
        }
        System.out.println(" " + "-".repeat(SIZE * 6 - 1));
    }
}
