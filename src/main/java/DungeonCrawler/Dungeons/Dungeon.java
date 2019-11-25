package DungeonCrawler.Dungeons;

import DungeonCrawler.Entity;
import DungeonCrawler.Item;
import DungeonCrawler.Room;
import DungeonCrawler.Spells.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public abstract class Dungeon {

    protected Room[][] dungeon;
    protected Map<String, Entity> enemies;
    protected Map<String, Item> items;
    protected Map<String, Spell> spells;
    protected Map<String, Room> rooms;
    protected String[] difficulties;
    protected int size;

    public Room[][] generateDungeon() {
        Random random = new Random();
        for (int i = 0; i < size * size - 1; i++) {
            registerRooms();
            int index;
            if (i / 5 > i % 5) {
                index = random.nextInt(2) + i / size;
            } else {
                index = random.nextInt(2) + i % size;
            }
            Room newRoom = rooms.get(difficulties[index]);
            newRoom.setId(i);
            dungeon[i / size][i % size] = new Room(newRoom);
            rooms.clear();
        }
        registerRooms();
        Room bossRoom = rooms.get("final");
        bossRoom.setId(24);
        dungeon[size - 1][size - 1] = new Room(bossRoom);
        return dungeon;
    }

    public abstract Map<String, Item> registerItems();

    public abstract Map<String, Spell> registerSpells();

    public abstract Map<String, Entity> registerEnemies();

    public ArrayList<Spell> makeSpellArray(String[] spells) {
        ArrayList<Spell> newSpells = new ArrayList<>();
        for (int i = 0; i < spells.length; i++) {
            registerSpells();
            Spell newSpell = this.spells.get(spells[i]);
            newSpells.add(newSpell);
            this.spells.clear();
        }
        return newSpells;
    }

    public abstract Map<String, Room> registerRooms();

    public void makeRoom(String[] items, String[] enemies, String name) {
        ArrayList<Entity> newEnemies = new ArrayList<>();
        ArrayList<Item> newItems = new ArrayList<>();
        for (int i = 0; i < enemies.length; i++) {
            registerEnemies();
            Entity newEnemy = this.enemies.get(enemies[i]);
            newEnemies.add(newEnemy);
            this.enemies.clear();
        }
        for (int i = 0; i < items.length; i++) {
            Item item = this.items.get(items[i]);
            newItems.add(item);
        }
        Random random = new Random();
        int luck = random.nextInt(2);
        for (int i = 0; i < luck; i++) {
            int index = random.nextInt(this.items.size());
            Object[] allItems = this.items.values().toArray();
            newItems.add((Item) allItems[index]);
        }
        rooms.put(name, new Room(newEnemies, newItems));
    }

}
