package DungeonCrawler.Dungeons;

import DungeonCrawler.Armour;
import DungeonCrawler.Enemies.*;
import DungeonCrawler.Entity;
import DungeonCrawler.Item;
import DungeonCrawler.Potions.*;
import DungeonCrawler.Room;
import DungeonCrawler.Spells.*;

import java.util.HashMap;
import java.util.Map;

public class DungeonTutorial extends Dungeon{

    public DungeonTutorial() {
        difficulties = new String[]{"easy", "midEasy", "medium", "midMedium", "hard", "midHard", "final"};
        dungeon = new Room[5][5];
        size = 5;
        enemies = new HashMap<>();
        items = new HashMap<>();
        spells = new HashMap<>();
        rooms = new HashMap<>();
    }

    public Map<String, Item> registerItems() {
        items.put("hp", new PotionHP());
        items.put("mp", new PotionMP());
        items.put("def", new PotionDef());
        items.put("blind", new PotionBlind());
        items.put("steelHelmet", new Armour("Steel helmet", 9, "Adds 6 defense", 0));
        items.put("steelChestplate", new Armour("Steel chestplate", 12, "Adds 10 defense", 1));
        items.put("steelPants", new Armour("Steel pants", 11, "Adds 9 defense", 2));
        items.put("steelShield", new Armour("Steel shield", 9, "Adds 6 defense", 3));
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
        enemies.put("tutorial", new EnemyBasic(20, 10, 10, "tutorial", makeSpellArray(new String[]{"heal"})));
        enemies.put("tutorialSenior", new EnemyBasic(40, 20, 15, "tutorial senior", makeSpellArray(new String[]{"dab"})));
        enemies.put("tutorialChief", new EnemyBasic(60, 30, 20, "tutorial chief", makeSpellArray(new String[]{"banana"})));
        enemies.put("tutorialBoss", new EnemyBasic(80, 40, 25, "tutorial boss", makeSpellArray(new String[]{"slap"})));
        enemies.put("tutorialPresident", new EnemyBasic(100, 50, 50, "tutorial president", makeSpellArray(new String[]{"influencer"})));
        enemies.put("tutorialGod", new EnemyBasic(120, 60, 60, "tutorial god", makeSpellArray(new String[]{"blackHole", "godlyInfluencer", "bigHeal", "rest"})));
        return enemies;
    }

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

}
