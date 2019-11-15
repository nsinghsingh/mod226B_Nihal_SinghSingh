package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

import java.util.Random;
import java.util.Scanner;

public class SpellInfluencer extends Spell{

    private int hits;

    public SpellInfluencer() {
        super(20, 40, "Do you even know who I am?", "Influencer power");
        this.hits = 4;
    }

    public SpellInfluencer(int cost, int value, String attackCry, String name, int hits) {
        super(cost, value, attackCry, name);
        this.hits = hits;
    }

    public SpellInfluencer(Spell spell) {
        super(spell);
        try {
            hits = ((SpellInfluencer) spell).hits;
        } catch (Exception e) {
            hits = 4;
        }

    }

    @Override
    public boolean fire(Entity opponent) {
        if (user.getMp() < cost) {
            System.out.println(user.getName() + " tried to fire a spell but didn't have enough mana!");
            return false;
        } else {
            System.out.print(attackCry);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            Random random = new Random();
            int luck = random.nextInt(hits + 1);
            for (int i = 0; i < luck; i++) {
                System.out.print((i+1) + " hit(s)");
                input = scanner.nextLine();
                opponent.getAttacked(value/hits);
            }
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}