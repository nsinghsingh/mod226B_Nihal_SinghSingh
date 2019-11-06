package DungeonCrawler;

import java.util.ArrayList;

public class Dungeon {

    private static int level;
    protected Room[][] dungeon = new Room[5][5];
    private ArrayList<Entity> enemies;
    private ArrayList<Item> items;
    private ArrayList<Spell> spells;

    public void generateDungeon() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                dungeon[i][j] = new Room();
            }
        }
    }

    public void registerItems() {

    }

    public void registerSpells() {

        spells.add(new Spell(8, 7, "HEAL!", "Healing scream"));
    }

    public void registerEnemies() {
        ArrayList<Spell> newSpell = new ArrayList<>();
        newSpell.add(spells.get(0));
        enemies.add(new EnemyBasic(10, 10, 10, "tutorial", newSpell));
        newSpell.set(0, spells.get(1));
        enemies.add(new EnemyBasic(20, 20, 20, "tutorial senior", newSpell));
        newSpell.set(0, spells.get(2));
        enemies.add(new EnemyBasic(30, 30, 30, "tutorial chief", newSpell));
        newSpell.set(0, spells.get(3));
        enemies.add(new EnemyBasic(40, 40, 40, "tutorial boss", newSpell));
        newSpell.set(0, spells.get(4));
        enemies.add(new EnemyBasic(50, 50, 50, "tutorial president", newSpell));
        newSpell.set(0, spells.get(5));
        enemies.add(new EnemyBasic(60, 60, 60, "tutorial god", newSpell));
    }
}
