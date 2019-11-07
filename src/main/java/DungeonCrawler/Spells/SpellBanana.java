package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

import java.util.Scanner;

public class SpellBanana extends Spell{

    public SpellBanana() {
        this.cost = 11;
        this.value = 14;
        this.attackCry = "Take this banana!";
        this.name = "Banana slip";
    }

    public SpellBanana(int cost, int damage, String attackCry, String name) {
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
            opponent.setDefense(opponent.getDefense()- value /2);
            System.out.println(opponent.getName() + " defense has been lowered!");
            opponent.getAttacked(value /2);
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}
