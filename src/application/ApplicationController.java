package application;

import games.Game;

public class ApplicationController {
    private MenuApplicationView menu;
    private Interaction interaction;
    private Game game;

    public ApplicationController() {
        menu = new MenuApplicationView();
        interaction = new Interaction();
    }

    public void startApplication() {
        menu.displayMenu();
        int menuChoice = interaction.getMenuApp();
        game = GameFactory.creatGame(menuChoice);
        if (game != null) {
            game.startGame();
        }else {
            menu.showMessage("Choix invalide. Relancez l'application.");
        }
    }
}
