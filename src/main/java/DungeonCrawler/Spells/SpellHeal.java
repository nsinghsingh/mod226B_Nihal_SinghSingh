package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

import java.util.Scanner;

public class SpellHeal extends Spell {

    public SpellHeal() {
        this.cost = 10;
        this.value = 18;
        this.attackCry = "HEAAAAAAAAAAAAAAAAAL!";
        this.name = "Healing Scream";
    }

    public SpellHeal(int cost, int damage, String attackCry, String name) {
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
            System.out.print(attackCry);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            user.setHp(user.getHp() + value);
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}

