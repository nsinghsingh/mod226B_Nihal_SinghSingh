package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

import java.util.Scanner;

public class SpellBanana extends Spell {

    public SpellBanana() {
        super(11, 14, "Take this banana!", "Banana slip");
    }

    public SpellBanana(int cost, int value, String attackCry, String name) {
        super(cost, value, attackCry, name);
    }

    public SpellBanana(Spell spell) {
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
            opponent.setDefense(opponent.getDefense() - value / 2);
            System.out.println(opponent.getName() + " defense has been lowered!");
            opponent.getAttacked(value / 2);
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}
