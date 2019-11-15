package Arcade;

import TicTacToe.TicTacToeMain;

public class ArcadeboxTicTacToe implements Arcadebox{

    private TicTacToeMain ticTacToe;

    public void start() {
        ticTacToe = new TicTacToeMain();
        run();
    }

    public void run() {
        ticTacToe.load();
        stop();
    }

    public void stop() {
        ticTacToe = null;
    }
}
