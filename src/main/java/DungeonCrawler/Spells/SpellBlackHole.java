package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

import java.util.Scanner;

public class SpellBlackHole extends Spell{

    public SpellBlackHole() {
        this.cost = 1;
        this.damage = 100;
        this.attackCry = "Be reduced to atoms";
        this.name = "Universal finisher";
    }

    public SpellBlackHole(Entity user, int cost, int damage, String attackCry, String name) {
        this.user = user;
        this.cost = cost;
        this.damage = damage;
        this.attackCry = attackCry;
        this.name = name;
    }

    @Override
    public boolean fire(Entity opponent, Entity user) {
        if (user.getMp() < cost) {
            return false;
        } else {
            System.out.println(attackCry);
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            opponent.getAttacked(damage);
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}
