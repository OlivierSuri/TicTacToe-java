package demo;

import tictactoe.InteractionUtilisateur;

public class InteractUtil extends InteractionUtilisateur implements PositionGenerator {
    @Override
    public int getPosition(int max) {
        int pos;
        do {
            pos=getIntInput();
        } while(pos>max);
        return pos;
    }
}
