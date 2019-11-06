package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

public class SpellBeachSlap extends Spell{

    public SpellBeachSlap() {
        this.cost = 13;
        this.damage = 20;
        this.attackCry = "Get outta here";
        this.name = "Beach slap";
    }

    @Override
    public boolean fire(Entity opponent, Entity user) {
        if (user.getMp() < cost) {
            return false;
        } else {
            System.out.println(attackCry);
            opponent.getAttacked(damage);
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}