package tictactoe;

import common.model.*;
import games.Game;


public class TicTacToeController implements Game {
    private final Board board;
    private final TicTacToeLogic logic;
    private final TicTacToeView ticTacToeView;
    private final InteractionUtilisateur interaction;
    private Player player1;
    private Player player2;

    public TicTacToeController() {
        board = new Board(3,3,3);
        logic = new TicTacToeLogic();
        interaction = new InteractionUtilisateur(); // Créer une instance
        ticTacToeView = new TicTacToeView(); // Passer l'interaction à la vue
    }

    @Override
    public void startGame() {

        // Affichage choix du type de partie
        ticTacToeView.displayMenuGameTypeChoice();
        int gameType = interaction.menuGameTypeChoice();


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
                ticTacToeView.showMessage("Choix invalide. Relancez le jeu.");
                return; // Arrête le jeu si le type est invalide
        }

        Player currentPlayer = player1; // Commence par le joueur 1

        while (true) {
            ticTacToeView.displayBoard(board); // Afficher le plateau
            ticTacToeView.displayPlayerMoveMenu(currentPlayer);
            // Valider et appliquer le coup
            int row, col;
            while (true) {
                int[] move = currentPlayer.getMove(board); // Obtenir le mouvement en polymorphisme de player
//                    int[] move;
//                       if (currentPlayer instanceof ArtificialPlayer ap){ //obtenir le mouvement de chaque player human ou IA
//                          move = ap.getMove(board);  //respect MVC
//                       }else {
//                        move = interaction.getMoveInput();
//                        }

                row = move[0];
                col = move[1];

                if (logic.isValidMove(board, row, col)) {
                    board.getCells(row, col).setStatus(currentPlayer.getStatus());
                    break; // Coup valide, sortir de la boucle
                } else {
                    ticTacToeView.showMessage("Coup invalide. Essayez encore.");
                }
            }

            // Vérifier victoire ou égalité
            if (logic.isWinningMove(board, row, col, currentPlayer.getStatus())) {
                ticTacToeView.displayBoard(board);
                ticTacToeView.showMessage("Le gagnant est : " + currentPlayer.getStatus() + " !");
                break; // Terminer la boucle principale
            } else if (logic.isDraw(board)) {
                ticTacToeView.displayBoard(board);
                ticTacToeView.showMessage("Match nul !");
                break; // Terminer la boucle principale
            }

            // Changer de joueur
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

}
