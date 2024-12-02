package model.common.model;

import view.view.InteractionUtilisateur;
import model.common.Status;

public class HumanPlayer extends Player {

    private final InteractionUtilisateur interaction;

    public HumanPlayer(Status representation, InteractionUtilisateur interaction) {
        super(representation);
        this.interaction=interaction;

    }

    @Override
    public int[] getMove(Board board) {
        // Appel au système d'interaction pour demander un coup
        return interaction.getMoveInput(board.getNbCoord());
    }
}
