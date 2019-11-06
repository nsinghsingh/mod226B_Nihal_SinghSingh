package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

import java.util.Random;

public class SpellInfluencer extends Spell{

    public SpellInfluencer() {
        this.cost = 20;
        this.damage = 40;
        this.attackCry = "Do you even know who I am?";
        this.name = "Influencer power";
    }

    public SpellInfluencer(Entity user, int cost, int damage, String attackCry, String name) {
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
            Random random = new Random();
            for (int i = 0; i < random.nextInt(4); i++) {
                System.out.println((i+1) + " hit(s)");
                opponent.getAttacked(damage/40);
            }
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}