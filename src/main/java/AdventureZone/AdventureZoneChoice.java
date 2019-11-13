package AdventureZone;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AdventureZoneChoice {
    private String text;
    private String leftText;
    private String rightText;
    private int leftChoice;
    private int rightChoice;

    public AdventureZoneChoice(String text, String leftText, String rightText, int leftChoice, int rightChoice) {
        this.text = text;
        this.leftText = leftText;
        this.rightText = rightText;
        this.leftChoice = leftChoice;
        this.rightChoice = rightChoice;
    }

}
