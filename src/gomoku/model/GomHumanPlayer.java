package gomoku.model;

import common.model.Board;
import common.model.Status;
import gomoku.GomokuView;

public class GomHumanPlayer extends GomokuPlayer {

    private GomokuView view;

    public GomHumanPlayer(Status representation, GomokuView view) {
        super(representation);
        this.view = view;
    }

    @Override
    public int[] getMove(Board board) {
        return view.getMove(this); // Demande les coordonnées au joueur via la vue
    }
}

