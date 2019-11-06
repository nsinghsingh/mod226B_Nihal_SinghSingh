package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

public class SpellBanana extends Spell{

    public SpellBanana() {
        this.cost = 11;
        this.damage = 14;
        this.attackCry = "Take this banana!";
        this.name = "Banana slip";
    }

    public SpellBanana(Entity user, int cost, int damage, String attackCry, String name) {
        this.user = user;
        this.cost = cost;
        this.damage = damage;
        this.attackCry = attackCry;
        this.name = name;
    }

    @Override
    public boolean fire(Entity opponent, Entity user) {
        if (user.getMp() < cost) {
            return false;
        } else {
            System.out.println(attackCry);
            opponent.setDefense(opponent.getDefense()-damage/2);
            System.out.println(opponent.getName() + " defense has been lowered!");
            opponent.getAttacked(damage/2);
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}
