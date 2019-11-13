package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

import java.util.Scanner;

public class SpellDab extends Spell {

    public SpellDab() {
        super(10, 25, "Dab on them haters", "Enrage");
    }

    public SpellDab(int cost, int value, String attackCry, String name) {
        super(cost, value, attackCry, name);
    }

    public SpellDab(Spell spell) {
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
            String input = scanner.nextLine();
            opponent.setAttack(opponent.getAttack() + value / 5);
            System.out.println(opponent.getName() + " attack has been increased!");
            opponent.getAttacked(value * 4 / 5);
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}
