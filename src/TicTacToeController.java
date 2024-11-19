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
        player1 = new Player(" X ");
        player2 = new Player(" O ");
    }

    public void startGame() {
        Player currentPlayer = player1;
        boolean gameOngoing = true;

        while (gameOngoing) {
            view.displayBoard(board);
            boolean validMove = false;
            int row, col;
            //valider le coup du joueur
            do {
                int[] move = view.getMove(currentPlayer);
                row = move[0];
                col = move[1];

                if(logic.isValidMove(row, col)) {
                    board.getCell(row, col).setRepresentation(currentPlayer.getRepresentation());
                    validMove = true;
                }else {
                    view.showMessage("Invalid move");
                }

            }
           while (!validMove);
            if (logic.isWinningMove(row, col, currentPlayer.getRepresentation()))   {
                view.displayBoard(board);
                view.showMessage("Winner is "+currentPlayer.getRepresentation());
                gameOngoing = false;
            } else if (logic.isDraw()) {
                view.displayBoard(board);
                view.showMessage("Draw");
                gameOngoing = false;
            }



            // Changer de joueur
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }
}
