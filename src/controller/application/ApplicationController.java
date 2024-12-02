package controller.application;

import model.games.Game;
import view.Interaction;
import view.MenuApplicationView;

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
            menu.showMessage("Choix invalide. Relancez l'controller.application.");
        }
    }
}
