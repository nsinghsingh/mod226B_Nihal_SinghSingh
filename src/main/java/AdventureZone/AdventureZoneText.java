package AdventureZone;

import lombok.Getter;
import lombok.Setter;

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

    AdventureZoneText() throws IOException {
        String[] story = getText("C:/Users/vmadmin/Desktop/","Story.txt");
        String[] rightText = getText("","");
        String[] leftText = getText("","");
        int[] leftChoice = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int[] rightChoice = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = (choices.length - 1); i > -1; i--) {
            choices[i] = new AdventureZoneChoice(story[i], leftText[i], rightText[i], leftChoice[i], rightChoice[i]);
        }
    }
    public String[] getText(String directory, String file) throws IOException {
        Path path = Paths.get(directory, file);
        Charset charset = StandardCharsets.UTF_8;
        List<String> lines = Files.readAllLines(path, charset);
        String[] text = lines.toArray(new String[lines.size()]);
        return text;
    }
}

