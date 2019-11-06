package DungeonCrawler;

import DungeonCrawler.Spells.Spell;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

@Setter
@Getter

public class Player extends Entity {

    private ArrayList<Item> items;
    private Armour[] equipment = new Armour[4];
    private Room[][] dungeon;
    private Room currentroom;

    public Player(int hp, int mp, int attack, String name, ArrayList<Spell> spells, ArrayList<Item> items, Room[][] dungeon) {
        this.hp = hp;
        this.mp = mp;
        this.attack = attack;
        this.name = name;
        this.spells = spells;
        this.items = items;
        this.dungeon = dungeon;
        this.defense = 0;
    }

    public void getAttacked(int damage) {
        damage -= defense;
        if (damage < 0){
            damage = 0;
        }
        System.out.println("You took " + damage + " damage!");
    }

    public boolean attack(Entity opponent) {
        opponent.getAttacked(attack);
        if (opponent.getHp() <= 0) {
            System.out.println("You defeated " + opponent.getName());
            currentroom.getEnemies().remove(opponent);
        }
        return true;
    }

    public EnemyBasic targetEnemy(ArrayList<EnemyBasic> enemies) {

        System.out.println("Which enemy will you attack?");
        for (int i = 0; i < enemies.size(); i++) {
            System.out.print((i + 1) + ". " + enemies.get(i).getName() + "  ");
        }
        System.out.println("");
        EnemyBasic currentEnemy;
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine() != null) {
            currentEnemy = enemies.get(scanner.nextInt() - 1);
        } else {
            currentEnemy = enemies.get(0);
        }

        return currentEnemy;
    }

    public Spell chooseSpell(ArrayList<Spell> spells) {
        System.out.println("Which spell will you use?");
        for (int i = 0; i < spells.size(); i++) {
            System.out.print((i + 1) + ". " + spells.get(i).getName() + " (" + spells.get(i).getDamage() + " damage, " + spells.get(i).getCost() + " magic)  ");
        }
        System.out.println("");
        Spell currentSpell;
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine() != null) {
            currentSpell = spells.get(scanner.nextInt() - 1);
        } else {
            currentSpell = spells.get(0);
        }
        return currentSpell;
    }

    public Item chooseItem() {
        System.out.println("Which item will you use?");
        for (int i = 0; i < items.size(); i++) {
            System.out.print((i + 1) + ". " + items.get(i).getName() + " (" + items.get(i).getEffect() + " )  ");
        }
        System.out.println("");
        Item currentItem;
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine() != null) {
            currentItem = items.get(scanner.nextInt() - 1);
        } else {
            currentItem = items.get(0);
        }
        return currentItem;
    }

    public boolean run(Room room) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Which way do you want to go? Up, down, left or right?");
        String input = scanner.nextLine();
        Random random = new Random();
        int luck = random.nextInt(100);
        if (luck > 69) {
            System.out.println("You manage to escape!");
            move(input, room);
        } else {
            System.out.println("You can't see a way out!");
            return false;
        }
        return true;
    }

    public void move(String direction, Room room) {
        int id = room.getId();
        dungeon[id / 3][id % 3] = room;
        if ("up".equals(direction)) {
            try {
                currentroom = dungeon[(id / 3) - 1][id % 3];
            } catch (Exception e) {
                System.out.println("There isn't a room there!");
            }
        } else if ("down".equals(direction)) {
            try {
                currentroom = dungeon[(id / 3) + 1][id % 3];
            } catch (Exception e) {
                System.out.println("There isn't a room there!");
            }
        } else if ("left".equals(direction)) {
            try {
                currentroom = dungeon[id / 3][(id % 3) - 1];
            } catch (Exception e) {
                System.out.println("There isn't a room there!");
            }
        } else if ("right".equals(direction)) {
            try {
                currentroom = dungeon[id / 3][(id % 3) + 1];
            } catch (Exception e) {
                System.out.println("There isn't a room there!");
            }
        }
    }

    public void loot() {
        Scanner scanner = new Scanner(System.in);
        for (Item item : currentroom.getLoot()) {
            System.out.println("You found a " + item.getName());
            scanner.nextLine();
            items.add(item);
            currentroom.getLoot().remove(item);
        }
    }
}

