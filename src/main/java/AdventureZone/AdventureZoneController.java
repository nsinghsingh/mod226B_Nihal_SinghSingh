package AdventureZone;

import java.io.IOException;

public class AdventureZoneController {

    AdventureZoneText story = new AdventureZoneText();
    AdventureZoneChoice currentChoice;

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

    }
}
