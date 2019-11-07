package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

import java.util.Scanner;

public class SpellRest extends Spell {

    public SpellRest() {
        this.cost = 0;
        this.value = 21;
        this.attackCry = "ZZZZZZZZ";
        this.name = "Rest";
    }

    public SpellRest(int cost, int damage, String attackCry, String name) {
        this.cost = cost;
        this.value = damage;
        this.attackCry = attackCry;
        this.name = name;
    }

    @Override
    public boolean fire(Entity opponent) {
        user.setMp(user.getMp() + value);
        System.out.print(attackCry);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return true;
    }
}
