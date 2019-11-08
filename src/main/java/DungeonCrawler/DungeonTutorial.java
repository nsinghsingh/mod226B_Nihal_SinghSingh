package DungeonCrawler;

import DungeonCrawler.Enemies.EnemyBasic;
import DungeonCrawler.Potions.*;
import DungeonCrawler.Spells.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DungeonTutorial {

    private Room[][] dungeon = new Room[5][5];
    private Map<String, Entity> enemies = new HashMap<>();
    private Map<String, Item> items = new HashMap<>();
    private Map<String, Spell> spells = new HashMap<>();
    private Map<String, Room> rooms = new HashMap<>();
    private String[] difficulties = new String[]{"easy", "midEasy", "medium", "midMedium", "hard", "final"};

    public Room[][] generateDungeon() { // Add rooms instead of enemies and items
        registerRooms();
        Random random = new Random();
        for (int i = 0; i < 24; i++) {
            int index;
            if (i / 5 > i % 5) {
                index = random.nextInt(2) + i / 5;
            }
            else{
                index = random.nextInt(2) + i % 5;
            }
            Room newRoom = rooms.get(difficulties[index]);
            dungeon[i / 5][i % 5] = new Room(i, newRoom.getEnemies(), newRoom.getLoot());
        }
        Room bossRoom = rooms.get("final");
        dungeon[4][4] = new Room(25, bossRoom.getEnemies(), bossRoom.getLoot());
        return dungeon;
    }

    public Map<String, Item> registerItems() {
        items.put("hp", new PotionHP());
        items.put("mp", new PotionMP());
        items.put("def", new PotionDef());
        items.put("blind", new PotionBlind());
        items.put("steelHelmet", new Armour("Steel helmet", 6, "Adds 6 defense", 0));
        items.put("steelChestplate", new Armour("Steel chestplate", 10, "Adds 10 defense", 1));
        items.put("steelPants", new Armour("Steel pants", 9, "Adds 9 defense", 2));
        items.put("steelShield", new Armour("Steel shield", 6, "Adds 6 defense", 3));
        return items;
    }

    public Map<String, Spell> registerSpells() {
        spells.put("heal", new SpellHeal());
        spells.put("rest", new SpellRest());
        spells.put("bigHeal", new SpellHeal(16, 45, "You thought you could beat me?", "Big heal"));
        spells.put("godlyInfluencer", new SpellInfluencer(24, 100, 10, "Do you even know who I am?", "Godly influencer"));
        spells.put("dab", new SpellDab());
        spells.put("banana", new SpellBanana());
        spells.put("slap", new SpellBeachSlap());
        spells.put("influencer", new SpellInfluencer());
        spells.put("blackHole", new SpellBlackHole());
        return spells;
    }

    public Map<String, Entity> registerEnemies() {
        registerSpells();
        ArrayList<Spell> newSpell = new ArrayList<>();
        newSpell.add(spells.get("heal"));
        enemies.put("tutorial", new EnemyBasic(20, 10, 10, "tutorial", newSpell));
        newSpell.clear();
        newSpell.add(spells.get("dab"));
        enemies.put("tutorialSenior", new EnemyBasic(40, 20, 15, "tutorial senior", newSpell));
        newSpell.clear();
        newSpell.add(spells.get("banana"));
        enemies.put("tutorialChief", new EnemyBasic(60, 30, 20, "tutorial chief", newSpell));
        newSpell.clear();
        newSpell.add(spells.get("slap"));
        enemies.put("tutorialBoss", new EnemyBasic(80, 40, 25, "tutorial boss", newSpell));
        newSpell.clear();
        newSpell.add(spells.get("influencer"));
        enemies.put("tutorialPresident", new EnemyBasic(100, 50, 50, "tutorial president", newSpell));
        newSpell.clear();
        newSpell.add(spells.get("blackHole"));
        newSpell.add(spells.get("godlyInfluencer"));
        newSpell.add(spells.get("bigHeal"));
        newSpell.add(spells.get("rest"));
        enemies.put("tutorialGod", new EnemyBasic(120, 60, 60, "tutorial god", newSpell));
        return enemies;
    }

    public void makeEnemy(String[] spells, String keyName, String gameName, int[] hpMpAttack) {}

    public Map<String, Room> registerRooms() {
        registerEnemies();
        registerItems();
        makeRoom(new String[]{"hp"}, new String[]{"tutorial", "tutorial"}, "easy");
        makeRoom(new String[]{"mp"}, new String[]{"tutorial", "tutorialSenior"}, "midEasy");
        makeRoom(new String[]{"steelHelmet", "hp"}, new String[]{"tutorialBoss"}, "medium");
        makeRoom(new String[]{"hp", "hp", "blind"}, new String[]{"tutorialChief", "tutorialChief"}, "midMedium");
        makeRoom(new String[]{"mp", "mp", "steelChestplate"}, new String[]{"tutorialPresident", "tutorialBoss"}, "midMedium");
        makeRoom(new String[]{"blind", "def", "hp", "def"}, new String[]{"tutorialPresident", "tutorialChief"}, "hard");
        makeRoom(new String[]{"mp", "steelShield", "mp", "def"}, new String[]{"tutorialPresident", "tutorialChief", "tutorialBoss"}, "midHard");
        makeRoom(new String[]{"mp", "mp", "hp", "hp", "blind", "steelPants"}, new String[]{"tutorialGod"}, "final");
        return rooms;
    }

    public void makeRoom(String[] items, String[] enemies, String name) {
        ArrayList<Entity> newEnemies = new ArrayList<>();
        ArrayList<Item> newItems = new ArrayList<>();
        for (int i = 0; i < enemies.length; i++) {
            newEnemies.add(this.enemies.get(enemies[i]));
        }
        for (int i = 0; i < items.length; i++) {
            newItems.add(this.items.get(items[i]));
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
