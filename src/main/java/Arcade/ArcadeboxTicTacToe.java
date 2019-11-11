package Arcade;

import TicTacToe.TicTacToeMain;

public class ArcadeboxTicTacToe extends Arcadebox{

    TicTacToeMain ticTacToe;

    public void start(String[] args) {
        TicTacToeMain ticTacToe = new TicTacToeMain();
        ticTacToe.load(args);
        stop();
    }

    public void run() {

    }

    public void stop() {
        ticTacToe = null;
    }
}
