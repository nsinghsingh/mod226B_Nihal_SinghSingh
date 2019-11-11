package TicTacToe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TicTacToeMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/TicTacToe.fxml"));
        primaryStage.setTitle("Tic Tac Toe");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }
    public void load(String[] args){
        launch(args);
    }
}
