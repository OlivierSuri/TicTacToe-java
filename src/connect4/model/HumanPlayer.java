package connect4.model;

import common.model.Board;
import connect4.C4InteractionUtilisateur;
import tictactoe.model.Status;

public class HumanPlayer extends Player {
    private final C4InteractionUtilisateur interaction;

    public HumanPlayer(Status status, C4InteractionUtilisateur interaction) {
        super(status);
        this.interaction = interaction;
    }

    @Override
    public int getMove(Board board) {
        return interaction.getColumnInput(board.getSizeY());
    }

}
