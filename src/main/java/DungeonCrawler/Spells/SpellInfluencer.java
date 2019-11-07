package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

import java.util.Random;
import java.util.Scanner;

public class SpellInfluencer extends Spell{

    private int hits;

    public SpellInfluencer() {
        this.hits = 4;
        this.cost = 20;
        this.value = 40;
        this.attackCry = "Do you even know who I am?";
        this.name = "Influencer power";
    }

    public SpellInfluencer(int cost, int damage, int hits, String attackCry, String name) {
        this.cost = cost;
        this.value = damage;
        this.attackCry = attackCry;
        this.name = name;
        this.hits = hits;
    }

    @Override
    public boolean fire(Entity opponent) {
        if (user.getMp() < cost) {
            return false;
        } else {
            System.out.print(attackCry);
            Random random = new Random();
            for (int i = 0; i < random.nextInt(hits); i++) {
                System.out.print((i+1) + " hit(s)");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                opponent.getAttacked(value/hits);
            }
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}