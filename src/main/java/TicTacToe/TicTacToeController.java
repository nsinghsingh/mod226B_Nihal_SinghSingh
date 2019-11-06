package TicTacToe;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Time;
import java.util.concurrent.TimeUnit;


public class TicTacToeController {

    private int currentPlayer = 1;
    private int player1Wins;
    private int player2Wins;
    private int turns = 9;
    private boolean ai = false;
    private TicTacToeAI aiPlayer = new TicTacToeAI();

    @FXML
    private AnchorPane window;

    @FXML
    private AnchorPane choose;

    @FXML
    private Text player1Count;

    @FXML
    private Text player2Count;

    @FXML
    private Text winText;

    @FXML
    private GridPane board;

    @FXML
    public void setValue(ActionEvent event) {
        Object node = event.getSource();
        Button button = (Button) node;
        if (!button.getText().equals("X") && !button.getText().equals("O")) {
            if (currentPlayer == 1) {
                button.setText("X");
                checkWin(registerSquares());
                currentPlayer = 2;
                turns -= 1;
                if (ai && turns > 0){
                    aiPlayer.calculateMove(registerSquares(),1, 2);
                    Button square = (Button) board.getChildren().get(aiPlayer.getBestIndex());
                    square.setText("O");
                    checkWin(registerSquares());
                    currentPlayer = 1;
                    turns -= 1;
                }
            } else {
                button.setText("O");
                checkWin(registerSquares());
                currentPlayer = 1;
                turns -= 1;
            }
        }
    }

    public String[][] registerSquares() {
        String[][] squares = new String[3][3];
        for (int i = 0; i < 9; i++) {
            Button button = (Button) board.getChildren().get(i);
            squares[i / 3][i % 3] = button.getText();
        }
        return squares;
    }

    public void checkWin(String[][] squares) {
        for (int i = 0; i < 3; i++) {
            if (squares[i][0].equals(squares[i][1]) && squares[i][0].equals(squares[i][2]) && !squares[i][0].equals("")) {
                playerWon(currentPlayer);
            }
        }
        for (int i = 0; i < 3; i++) {
            if (squares[0][i].equals(squares[1][i]) && squares[0][i].equals(squares[2][i]) && !squares[0][i].equals("")) {
                playerWon(currentPlayer);
            }
        }
        if (squares[0][0].equals(squares[1][1]) && squares[0][0].equals(squares[2][2]) && !squares[0][0].equals("")) {
            playerWon(currentPlayer);
        }
        if (squares[2][0].equals(squares[1][1]) && squares[2][0].equals(squares[0][2]) && !squares[2][0].equals("")) {
            playerWon(currentPlayer);
        }
    }

    public void playerWon(int player){
        winText.setVisible(true);
        winText.setDisable(false);
        winText.setText("Player "+player+" won");
        board.setOpacity(0.1);
        for (int i = 0; i < 9; i++) {
            Button button = (Button) board.getChildren().get(i);
            button.setDisable(true);
        }
        if (player == 1){
            player1Wins += 1;
            player1Count.setText("Player 1: "+player1Wins);
        }
        else{
            player2Wins += 1;
            player2Count.setText("Player 2: "+player2Wins);
        }
        turns = 0;
    }

    public void reset(){
        for (int i = 0; i < 9; i++) {
            Button button = (Button) board.getChildren().get(i);
            button.setDisable(false);
            button.setText("");
        }
        board.setOpacity(1);
        winText.setVisible(false);
        winText.setDisable(true);
        currentPlayer = 1;
        turns = 9;
    }

    public void quit(){
        Platform.exit();
    }

    public void againstPlayer(){
        window.setDisable(false);
        window.setVisible(true);
        choose.setDisable(true);
        choose.setVisible(false);
    }

    public void againstAI(){
        ai = true;
        window.setDisable(false);
        window.setVisible(true);
        choose.setDisable(true);
        choose.setVisible(false);
    }
}
