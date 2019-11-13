package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

import java.util.Scanner;

public class SpellBlackHole extends Spell{

    public SpellBlackHole() {
        super(1, 100, "Be reduced to atoms", "Universal finisher");
    }

    public SpellBlackHole(int cost, int value, String attackCry, String name) {
        super(cost, value, attackCry, name);
    }

    public SpellBlackHole(Spell spell) {
        super(spell);
    }

    @Override
    public boolean fire(Entity opponent) {
        if (user.getMp() < cost) {
            System.out.println(user.getName() + " tried to fire a spell but didn't have enough mana!");
            return false;
        } else {
            System.out.print(attackCry);
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
            opponent.getAttacked(value);
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}
