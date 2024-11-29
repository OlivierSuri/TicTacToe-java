package connect4;

import common.model.Status;
import connect4.model.ArtificialPlayer;
import common.model.Board;
import connect4.model.HumanPlayer;
import connect4.model.Player;
import games.Game;

public class ConnectFourController implements Game {
    private final Board board;
    private final ConnectFourView view;
    private final C4InteractionUtilisateur interaction;
    private final ConnectFourLogic logic;
    private Player player1;
    private Player player2;

    public ConnectFourController() {
        board = new Board(6,7,4);
        view = new ConnectFourView();
        interaction = new C4InteractionUtilisateur();
        logic = new ConnectFourLogic();
    }

    @Override
    public void startGame() {
        view.displayMenuGameTypeChoice();
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
                view.showMessage("Choix invalide. Relancez le jeu.");
                return; // Arrête le jeu si le type est invalide
        }

            Player currentPlayer = player1;

            while (true) {
                view.displayBoard(board);

                int col;
                int row;

                while (true) {
                    col = currentPlayer.getMove(board);

                    if (!board.isColumnFull(col)) {
                        break;
                    } else {
                        view.showMessage("Colonne pleine ! Essayez encore.");
                    }
                }

                // Place le jeton
                for (row = board.getSizeX() - 1; row >= 0; row--) {
                    if (board.getCells(row, col).isEmpty()) {
                        board.getCells(row, col).setStatus(currentPlayer.getStatus());
                        break;
                    }
                }

                // Vérifier victoire ou égalité
                if (logic.isWinningMove(board, row, col, currentPlayer.getStatus())) {
                    view.displayBoard(board);
                    view.showMessage("Le gagnant est : " + currentPlayer.getStatus() + " !");
                    break; // Terminer la boucle principale
                } else if (logic.isDraw(board)) {
                    view.displayBoard(board);
                    view.showMessage("Match nul !");
                    break; // Terminer la boucle principale
                }

                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            }
    }
}
