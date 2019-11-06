package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

public class SpellHeal extends Spell {

    public SpellHeal() {
        this.cost = 10;
        this.damage = 14;
        this.attackCry = "HEAAAAAAAAAAAAAAAAAL!";
        this.name = "Healing Scream";
    }

    public SpellHeal(Entity user, int cost, int damage, String attackCry, String name) {
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
            user.setHp(user.getHp() + damage);
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}

