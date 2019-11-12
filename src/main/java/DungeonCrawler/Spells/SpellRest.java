package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

import java.util.Scanner;

public class SpellRest extends Spell {

    public SpellRest() {
        super(0, 21, "ZZZZZZZZ", "Rest");
    }

    public SpellRest(int cost, int value, String attackCry, String name) {
        super(cost, value, attackCry, name);
    }

    public SpellRest(Spell spell) {
        super(spell);
    }

    @Override
    public boolean fire(Entity opponent) {
        user.setMp(user.getMp() + value);
        System.out.print(attackCry);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return true;
    }
}
