package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

public class SpellDab extends Spell {

    public SpellDab() {
        this.cost = 10;
        this.damage = 15;
        this.attackCry = "Dab on them haters";
        this.name = "Enrage";
    }

    public SpellDab(Entity user, int cost, int damage, String attackCry, String name) {
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
            opponent.setAttack(opponent.getAttack()+damage/3);
            System.out.println(opponent.getName() + " attack has been increased!");
            opponent.getAttacked(damage*2/3);
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}
