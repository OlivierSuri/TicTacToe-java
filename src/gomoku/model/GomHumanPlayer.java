package gomoku.model;

import gomoku.GomokuView;
import gomoku.GomokuView;
import gomoku.model.GomokuPlayer;
import tictactoe.model.Status;

public class GomHumanPlayer extends GomokuPlayer {

    private GomokuView view;

    public GomHumanPlayer(Status representation, GomokuView view) {
        super(representation);
        this.view = view;
    }

    @Override
    public int[] getMove(GomokuBoard board) {
        return view.getMove(this); // Demande les coordonnées au joueur via la vue
    }
}

