package AdventureZone;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class AdventureZoneText {

    @Setter @Getter
    public AdventureZoneChoice[] choices = new AdventureZoneChoice[39];

    AdventureZoneText(){
        String[] story = getText("src/main/resources/","Story.txt");
        String[] rightText = getText("src/main/resources","Story.txt");
        String[] leftText = getText("src/main/resources","Story.txt");
        int[] leftChoice = new int[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] rightChoice = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < story.length; i++) {
            choices[i] = new AdventureZoneChoice(story[i], leftText[i], rightText[i], leftChoice[i], rightChoice[i]);
        }
    }
    public String[] getText(String directory, String file){
        try {
            Path path = Paths.get(directory, file);
            Charset charset = StandardCharsets.UTF_8;
            List<String> lines = Files.readAllLines(path, charset);
            String[] text = lines.toArray(new String[lines.size()]);
            return text;
        } catch (IOException ignored){
            return null;
        }
    }
}

