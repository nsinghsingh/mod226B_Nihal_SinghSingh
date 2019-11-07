package DungeonCrawler.Spells;

import DungeonCrawler.Entity;

public class SpellDab extends Spell {

    public SpellDab() {
        this.cost = 10;
        this.value = 15;
        this.attackCry = "Dab on them haters";
        this.name = "Enrage";
    }

    public SpellDab(int cost, int damage, String attackCry, String name) {
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
            System.out.println(attackCry);
            opponent.setAttack(opponent.getAttack()+ value /3);
            System.out.println(opponent.getName() + " attack has been increased!");
            opponent.getAttacked(value *2/3);
            user.setMp(user.getMp() - cost);
            return true;
        }
    }
}
