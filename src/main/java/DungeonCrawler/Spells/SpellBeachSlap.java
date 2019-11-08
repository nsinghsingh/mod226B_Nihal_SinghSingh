package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

import java.util.Scanner;

public class SpellBeachSlap extends Spell{

    public SpellBeachSlap() {
        this.cost = 13;
        this.value = 30;
        this.attackCry = "Get outta here";
        this.name = "Beach slap";
    }

    public SpellBeachSlap(int cost, int damage, String attackCry, String name) {
        this.cost = cost;
        this.value = damage;
        this.attackCry = attackCry;
        this.name = name;
    }

    @Override
    public boolean fire(Entity opponent) {
        if (user.getMp() < cost) {
            return false;
        } else {
            System.out.print(attackCry);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            opponent.getAttacked(value);
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}