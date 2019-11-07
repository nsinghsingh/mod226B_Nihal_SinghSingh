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

    public Room(int id) {
        this.id = id;
        this.enemies = new ArrayList<>();
        this.loot = new ArrayList<>();
    }
}
