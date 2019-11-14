package AdventureZone;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.io.IOException;

public class AdventureZoneController {

    private AdventureZoneText story = new AdventureZoneText();
    private AdventureZoneChoice currentChoice;

    @FXML
    private Button leftChoice;

    @FXML
    private Button rightChoice;

    @FXML
    private Text display;

    public AdventureZoneController() throws IOException {
    }

    public void chooseLeft(){
        int index = currentChoice.getLeftChoice();
        currentChoice = story.getChoices()[index];
        loadChoice();

    }
    public void chooseRight(){
        int index = currentChoice.getRightChoice();
        currentChoice = story.getChoices()[index];
        loadChoice();
    }
    public void loadChoice(){
        display.setText(currentChoice.getText());
        if (currentChoice.getLeftChoice() == 0){
            leftChoice.setDisable(true);
            rightChoice.setDisable(true);
        }
        else{
            leftChoice.setText(currentChoice.getLeftText());
            rightChoice.setText(currentChoice.getRightText());
        }
    }

    public void quit(){
        Platform.exit();
    }
}
