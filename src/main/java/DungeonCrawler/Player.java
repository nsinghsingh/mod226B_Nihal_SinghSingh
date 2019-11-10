package DungeonCrawler;

import DungeonCrawler.Potions.PotionHP;
import DungeonCrawler.Spells.Spell;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

@Setter
@Getter

public class Player extends Entity { //TO DO Allow debuffs and obtaining new spells

    private ArrayList<Item> items;
    private Armour[] equipment = new Armour[4];
    private Room[][] dungeon;
    private Room currentRoom;

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
        if (damage < 0) {
            damage = 0;
        }
        System.out.print("You took " + damage + " damage!");
        hp -= damage;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
    }

    public boolean attack(Entity opponent) {
        opponent.getAttacked(attack);
        if (opponent.getHp() <= 0) {
            enemyDefeated(opponent);
        }
        return true;
    }

    public Entity targetEnemy(ArrayList<Entity> enemies) {

        System.out.println("Which enemy will you attack?");
        for (int i = 0; i < enemies.size(); i++) {
            System.out.print((i + 1) + ". " + enemies.get(i).getName() + "  ");
        }
        System.out.println("");
        Entity currentEnemy;
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        try {
            currentEnemy = enemies.get(choice - 1);
        } catch (Exception e) {
            currentEnemy = enemies.get(0);
        }
        return currentEnemy;
    }

    public Spell chooseSpell(ArrayList<Spell> spells) {
        System.out.println("Which spell will you use?");
        for (int i = 0; i < spells.size(); i++) {
            System.out.print((i + 1) + ". " + spells.get(i).getName() + " (" + spells.get(i).getValue() + " value, " + spells.get(i).getCost() + " magic)  ");
        }
        System.out.println("");
        Spell currentSpell;
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        try {
            currentSpell = spells.get(choice - 1);
        } catch (Exception e) {
            currentSpell = spells.get(0);
        }
        return currentSpell;
    }

    public Item chooseItem() {
        System.out.println("Which item will you use?");
        for (int i = 0; i < items.size(); i++) {
            System.out.print((i + 1) + ". " + items.get(i).getName() + " (" + items.get(i).getEffect() + ")  ");
        }
        System.out.println("");
        Item currentItem;
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        try {
            currentItem = items.get(choice - 1);
        } catch (Exception e) {
            currentItem = new PotionHP("", 0, null, "");
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
            return true;
        }
        return true;
    }

    public void move(String direction, Room room) {
        int id = room.getId();
        dungeon[id / 5][id % 5] = room;
        if ("up".equals(direction)) {
            try {
                currentRoom = dungeon[(id / 5) - 1][id % 5];
            } catch (Exception e) {
                System.out.println("There isn't a room there!");
            }
        } else if ("down".equals(direction)) {
            try {
                currentRoom = dungeon[(id / 5) + 1][id % 5];
            } catch (Exception e) {
                System.out.println("There isn't a room there!");
            }
        } else if ("left".equals(direction)) {
            try {
                currentRoom = dungeon[id / 5][(id % 5) - 1];
            } catch (Exception e) {
                System.out.println("There isn't a room there!");
            }
        } else if ("right".equals(direction)) {
            try {
                currentRoom = dungeon[id / 5][(id % 5) + 1];
            } catch (Exception e) {
                System.out.println("There isn't a room there!");
            }
        }
    }

    public void loot() {
        Scanner scanner = new Scanner(System.in);
        if (currentRoom.getLoot().size() > 0) {
            for (Item item : currentRoom.getLoot()) {
                System.out.print("You found a " + item.getName());
                scanner.nextLine();
                items.add(item);
            }
            currentRoom.getLoot().clear();
        } else {
            System.out.println("You found nothing :(");
            scanner.nextLine();
        }
    }

    public void enemyDefeated(Entity opponent) {
        Random random = new Random();
        int luck = random.nextInt(100);
        System.out.println("You defeated " + opponent.getName());
        if (40 >= luck) {
            int index = random.nextInt(opponent.getSpells().size());
            Spell newSpell = opponent.getSpells().get(index);
            boolean hasSpell = false;
            for (Spell spell : spells) {
                if (spell.getName().equals(newSpell.getName())) {
                    hasSpell = true;
                    spell.setValue((int) (spell.getValue() * 1.2));
                    spell.setCost((int) (spell.getCost() * 1.1));
                    System.out.println("After defeating " + opponent.getName() + " " + spell.getName() + " became stronger!");
                    break;
                }
            }
            if (!hasSpell) {
                System.out.println("After defeating " + opponent.getName() + " you obtained "  + newSpell.getName());
                spells.add(newSpell);
            }
        }
        currentRoom.getEnemies().remove(opponent);
    }
}

