package AdventureZone;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventureZoneText {

    @Setter
    @Getter
    public AdventureZoneChoice[] choices = new AdventureZoneChoice[39];

    AdventureZoneText() {
        String[] story = getText("src/main/resources/", "Story.txt");
        String[] rightText = getText("src/main/resources/", "Right.txt");
        String[] leftText = getText("src/main/resources/", "Left.txt");
        int[] leftChoice =  new int[]{1, 3, 5, 0, 7, 9, 0, 0, 11, 0, 13, 0, 15, 17, 0, 19, 0, 21, 0, 23, 0, 0, 25, 27, 0, 29, 0, 0, 31, 0, 33, 0, 35, 0, 37, 0, 0, 0, 0};
        int[] rightChoice = new int[]{2, 4, 6, 0, 8, 10, 0, 0, 12, 0, 14, 0, 16, 18, 0, 20, 0, 22, 0, 24, 0, 0, 26, 28, 0, 30, 0, 0, 32, 0, 34, 0, 36, 0, 38, 0, 0, 0, 0};
        for (int i = 0; i < story.length; i++) {
            choices[i] = new AdventureZoneChoice(story[i], leftText[i], rightText[i], leftChoice[i], rightChoice[i]);
        }
    }

    public String[] getText(String directory, String file) {
        try {
            String[] story = new String[39];
            Scanner read = new Scanner(new File(directory + file));
            read.useDelimiter("-");
            for (int i = 0; i < story.length; i++) {
                story[i] = read.next();
            }
            return story;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}

