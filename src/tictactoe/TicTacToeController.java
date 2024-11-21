package tictactoe;

import tictactoe.model.*;

public class TicTacToeController {
    private final Board board;
    private final TicTacToeLogic logic;
    private final TicTacToeView view;
    private Player player1;
    private Player player2;

    public TicTacToeController() {
        board = new Board();
        logic = new TicTacToeLogic(board);
        InteractionUtilisateur interaction = new InteractionUtilisateur(); // Créer une instance
        view = new TicTacToeView(interaction); // Passer l'interaction à la vue
    }

    public void startGame() {
        // Choix du type de partie
        int gameType = view.menuGameTypeChoice();

        switch (gameType) {
            case 1: // Joueur contre Joueur
                player1 = new HumanPlayer(Status.X, view);
                player2 = new HumanPlayer(Status.O, view);
                break;
            case 2: // Joueur contre IA
                player1 = new HumanPlayer(Status.X, view);
                player2 = new ArtificialPlayer(Status.O);
                break;
            case 3: // IA contre IA
                player1 = new ArtificialPlayer(Status.X);
                player2 = new ArtificialPlayer(Status.O);
                break;
            default:
                view.showMessage("Choix invalide. Relancez le jeu.");
                return; // Arrête le jeu si le type est invalide
        }

        Player currentPlayer = player1; // Commence par le joueur 1

        while (true) {
            view.displayBoard(board); // Afficher le plateau

            // Valider et appliquer le coup
            int row, col;
            while (true) {
                int[] move = currentPlayer.getMove(board); // Obtenir le mouvement
                row = move[0];
                col = move[1];

                if (logic.isValidMove(row, col)) {
                    board.getCell(row, col).setStatus(currentPlayer.getStatus());
                    break; // Coup valide, sortir de la boucle
                } else {
                    view.showMessage("Coup invalide. Essayez encore.");
                }
            }

            // Vérifier victoire ou égalité
            if (logic.isWinningMove(row, col, currentPlayer.getStatus())) {
                view.displayBoard(board);
                view.showMessage("Le gagnant est : " + currentPlayer.getStatus() + " !");
                break; // Terminer la boucle principale
            } else if (logic.isDraw()) {
                view.displayBoard(board);
                view.showMessage("Match nul !");
                break; // Terminer la boucle principale
            }

            // Changer de joueur
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}
