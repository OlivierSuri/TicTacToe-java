package application;

import connect4.ConnectFourController;
import games.Game;
import gomoku.GomokuController;
import tictactoe.TicTacToeController;

public class GameFactory {

    public static Game creatGame (int choice) {
        switch (choice) {
            case 1 :
                return new TicTacToeController();

            case 2 :
                return new GomokuController();

            case 3 :
                return new ConnectFourController();

            default:
                System.out.println("invalid choice");
                return null;
        }
    }
}
