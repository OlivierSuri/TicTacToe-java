public class TicTacToeController {
    private Board board;
    private TicTacToeLogic logic;
    private TicTacToeView view;
    private Player player1;
    private Player player2;

    public TicTacToeController() {
        board = new Board();
        logic = new TicTacToeLogic(board);
        view = new TicTacToeView();
    }

    public void startGame() {
        // Choix du type de partie
        int gameType = view.menuGameTypeChoice();
        switch (gameType) {
            case 1: // Joueur contre Joueur
                player1 = new HumanPlayer(" X ", view);
                player2 = new HumanPlayer(" O ", view);
                break;
            case 2: // Joueur contre IA
                player1 = new HumanPlayer(" X ", view);
                player2 = new ArtificialPlayer(" O ");
                break;
            case 3: // IA contre IA
                player1 = new ArtificialPlayer(" X ");
                player2 = new ArtificialPlayer(" O ");
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
                    board.getCell(row, col).setRepresentation(currentPlayer.getRepresentation());
                    break; // Coup valide, sortir de la boucle
                } else {
                    view.showMessage("Coup invalide. Essayez encore.");
                }
            }

            // Vérifier victoire ou égalité
            if (logic.isWinningMove(row, col, currentPlayer.getRepresentation())) {
                view.displayBoard(board);
                view.showMessage("Le gagnant est : " + currentPlayer.getRepresentation() + " !");
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
