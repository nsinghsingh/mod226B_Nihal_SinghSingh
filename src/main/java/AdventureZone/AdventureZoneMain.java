package AdventureZone;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdventureZoneMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/AdventureZone.fxml"));
        primaryStage.setTitle("Adventure Zone");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.setAlwaysOnTop(true);
        primaryStage.show();
    }
    public void load(){
        launch();
    }
}