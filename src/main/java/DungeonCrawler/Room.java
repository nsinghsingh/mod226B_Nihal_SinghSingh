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

    public Room(ArrayList<Entity> enemies, ArrayList<Item> loot) {
        this.id = 0;
        this.enemies = enemies;
        this.loot = loot;
    }

    public Room(Room room) {
        this.id = room.getId();
        this.enemies = room.getEnemies();
        this.loot = room.getLoot();
    }

    public Room(int id, ArrayList<Entity> enemies, ArrayList<Item> loot) {
        this.id = id;
        this.enemies = enemies;
        this.loot = loot;
    }
}
