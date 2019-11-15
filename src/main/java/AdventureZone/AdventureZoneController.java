package AdventureZone;

import java.util.Scanner;

public class AdventureZoneController {

    private AdventureZoneText story = new AdventureZoneText();
    private AdventureZoneChoice currentChoice = story.getChoices()[0];


    public void chooseLeft(){
        int index = currentChoice.getLeftChoice();
        currentChoice = story.getChoices()[index];
        load();

    }
    public void chooseRight(){
        int index = currentChoice.getRightChoice();
        currentChoice = story.getChoices()[index];
        load();
    }
    public void load(){
        System.out.print(currentChoice.getText());
        if (currentChoice.getRightChoice() == 0){
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }
        else{
            System.out.println("1. " + currentChoice.getLeftText().concat(" 2. " + currentChoice.getRightText()));
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("1")){
                chooseLeft();
            }
            else if (input.equals("2")){
                chooseRight();
            }
        }
    }
}
