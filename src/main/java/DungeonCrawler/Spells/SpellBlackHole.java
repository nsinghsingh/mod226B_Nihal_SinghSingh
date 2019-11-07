package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

import java.util.Scanner;

public class SpellBlackHole extends Spell{

    public SpellBlackHole() {
        this.cost = 1;
        this.value = 100;
        this.attackCry = "Be reduced to atoms";
        this.name = "Universal finisher";
    }

    public SpellBlackHole(int cost, int damage, String attackCry, String name) {
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
            System.out.println(attackCry);
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            opponent.getAttacked(value);
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}
