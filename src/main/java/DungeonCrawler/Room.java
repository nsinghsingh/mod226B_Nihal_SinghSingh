package DungeonCrawler;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter
public class Room {

    private int id;
    private ArrayList<Entity> enemies;
    private ArrayList<Item> loot;
}
