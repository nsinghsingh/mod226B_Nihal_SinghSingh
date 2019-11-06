package DungeonCrawler;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Setter
@Getter
public abstract class DungeonCrawlerController {

    protected Player player;
    protected Room currentRoom;
    protected Scanner scanner = new Scanner(System.in);

    public abstract void isFighting();

    public abstract void displayOptions();
}
