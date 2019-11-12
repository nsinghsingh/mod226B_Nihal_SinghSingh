package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

import java.util.Scanner;

public class SpellBeachSlap extends Spell{

    public SpellBeachSlap() {
        super(13, 30, "Get outta here", "Beach slap");
    }

    public SpellBeachSlap(int cost, int value, String attackCry, String name) {
        super(cost, value, attackCry, name);
    }

    public SpellBeachSlap(Spell spell) {
        super(spell);
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