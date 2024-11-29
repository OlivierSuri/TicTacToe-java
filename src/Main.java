import application.ApplicationController;
import connect4.ConnectFourController;
import gomoku.GomokuController;
import tictactoe.TicTacToeController;

public class Main {
    public static void main(String[] args) {
//        ApplicationController appController = new ApplicationController();
//        appController.startApplication();
        ConnectFourController connectFourController = new ConnectFourController();
        connectFourController.startGame();
    }
}
