import application.ApplicationController;
import connect4.ConnectFourController;
import gomoku.GomokuController;
import tictactoe.TicTacToeController;

public class Main {
    public static void main(String[] args) {
//        ApplicationController appController = new ApplicationController();
//        appController.startApplication();
        GomokuController gomokuController = new GomokuController();
        gomokuController.startGame();
    }
}
