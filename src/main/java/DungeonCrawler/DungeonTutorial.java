package DungeonCrawler;

import DungeonCrawler.Enemies.EnemyBasic;
import DungeonCrawler.Potions.*;
import DungeonCrawler.Spells.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DungeonTutorial {

    protected Room[][] dungeon = new Room[5][5];
    private Map<String, Entity> enemies = new HashMap<>();
    private Map<String, Item> items = new HashMap<>();
    private Map<String, Spell> spells = new HashMap<>();
    private int itemsPerRoom = 2;
    private int enemiesPerRoom = 2;

    public Room[][] generateDungeon() {
        registerEnemies();
        registerItems();
        Random random = new Random();
        for (int i = 0; i < 24; i++) {
            dungeon[i / 5][i % 5] = new Room(i);
            for (int j = 0; j <= random.nextInt(itemsPerRoom ); j++) {
                int index = random.nextInt(items.size());
                Object[] allItems = items.values().toArray();
                dungeon[i / 5][i % 5].getLoot().add((Item) allItems[index]);
            }
            for (int j = 0; j <= random.nextInt(enemiesPerRoom); j++) {
                int index = random.nextInt(enemies.size());
                Object[] allEnemies = enemies.values().toArray();
                dungeon[i / 5][i % 5].getEnemies().add((Entity) allEnemies[index]);
            }
        }
        Room bossRoom = new Room(25);
        bossRoom.getLoot().add(items.get("hp"));
        bossRoom.getLoot().add(items.get("hp"));
        bossRoom.getLoot().add(items.get("mp"));
        bossRoom.getLoot().add(items.get("mp"));
        bossRoom.getLoot().add(items.get("def"));
        bossRoom.getEnemies().add(enemies.get("tutorialGod"));
        dungeon[4][4] = bossRoom;
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
        return  items;
    }

    public Map<String, Spell> registerSpells() {
        spells.put("heal", new SpellHeal());
        spells.put("rest", new SpellRest());
        spells.put("bigHeal", new SpellHeal(16, 40, "You thought you could beat me?", "Big heal"));
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
        /*
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
        */
        return enemies;
    }
}
