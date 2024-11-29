package gomoku;

import common.model.Status;
import games.Game;
import common.model.Player;
import common.model.ArtificialPlayer;
import common.model.Board;
import common.model.HumanPlayer;
import tictactoe.InteractionUtilisateur;

public class GomokuController implements Game {

    private final Board board;
    private final GomokuLogic logic;
    private final GomokuView gomokuView;
    private final InteractionUtilisateur interaction;
    private Player player1;
    private Player player2;

    public GomokuController() {
        board = new Board(15,15,5);
        logic = new GomokuLogic();
        interaction = new InteractionUtilisateur(); // Créer une instance
        gomokuView = new GomokuView(interaction); // Passer l'interaction à la vue
    }

    @Override
    public void startGame() {
        // Choix du type de partie
        int gameType = gomokuView.menuGameTypeChoice();

        switch (gameType) {
            case 1: // Joueur contre Joueur
                player1 = new HumanPlayer(Status.X, interaction);
                player2 = new HumanPlayer(Status.O, interaction);
                break;
            case 2: // Joueur contre IA
                player1 = new HumanPlayer(Status.X, interaction);
                player2 = new ArtificialPlayer(Status.O);
                break;
            case 3: // IA contre IA
                player1 = new ArtificialPlayer(Status.X);
                player2 = new ArtificialPlayer(Status.O);
                break;
            default:
                gomokuView.showMessage("Choix invalide. Relancez le jeu.");
                return; // Arrête le jeu si le type est invalide
        }

        Player currentPlayer = player1; // Commence par le joueur 1

        while (true) {
            gomokuView.displayBoard(board); // Afficher le plateau

            // Valider et appliquer le coup
            int row, col;
            while (true) {
                int[] move = currentPlayer.getMove(board); // Obtenir le mouvement
                row = move[0];
                col = move[1];

                if (logic.isValidMove(board, row, col)) {
                    board.getCells(row, col).setStatus(currentPlayer.getStatus());
                    break; // Coup valide, sortir de la boucle
                } else {
                    gomokuView.showMessage("Coup invalide. Essayez encore.");
                }
            }

            // Vérifier victoire ou égalité
            if (logic.isWinningMove(board, row, col, currentPlayer.getStatus())) {
                gomokuView.displayBoard(board);
                gomokuView.showMessage("Le gagnant est : " + currentPlayer.getStatus() + " !");
                break; // Terminer la boucle principale
            } else if (logic.isDraw(board)) {
                gomokuView.displayBoard(board);
                gomokuView.showMessage("Match nul !");
                break; // Terminer la boucle principale
            }

            // Changer de joueur
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}
