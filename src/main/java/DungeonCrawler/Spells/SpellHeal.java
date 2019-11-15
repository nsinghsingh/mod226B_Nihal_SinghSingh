package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

import java.util.Scanner;

public class SpellHeal extends Spell {

    public SpellHeal() {
        super(10, 24, "HEAAAAAAAAAAAAAAAAAL!", "Healing Scream");
    }

    public SpellHeal(int cost, int value, String attackCry, String name) {
        super(cost, value, attackCry, name);
    }

    public SpellHeal(Spell spell) {
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
            user.setHp(user.getHp() + value);
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}

