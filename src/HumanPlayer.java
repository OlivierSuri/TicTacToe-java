public class HumanPlayer extends Player {
    private TicTacToeView view;

    public HumanPlayer(String representation, TicTacToeView view) {
        super(representation);
        this.view = view;
    }

    @Override
    public int[] getMove(Board board) {
        return view.getMove(this); // Demande les coordonnées au joueur via la vue
    }
}
