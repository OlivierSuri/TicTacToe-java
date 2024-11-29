package demo;

public class PlayerFactory {

    public static Player makePlayer(char choice){
        return switch(choice){
            case 'h' -> new HumanPlayer();
            case 'a' -> new AIPlayer();
            default -> null;
        };
    }

    public static Player makePlayer(PosStrategies strategy) {
        return switch (strategy) {
            case HUMAN -> new HumanPlayer();
            case AI -> new AIPlayer();
        };

    }
}
