package DungeonCrawler;

import DungeonCrawler.Spells.Spell;

import java.util.ArrayList;

public class EnemyBasic extends Entity {

    public EnemyBasic(int hp, int mp, int attack, String name, ArrayList<Spell> spells) {
        this.hp = hp;
        this.mp = mp;
        this.attack = attack;
        this.name = name;
        this.spells = spells;
        this.defense = 0;
    }

    public void getAttacked(int damage) {
        damage -= defense;
        if (damage < 0){
            damage = 0;
        }
        System.out.println(name + " took " + damage + " damage!");
    }

    public boolean attack(Entity opponent) {
        opponent.getAttacked(attack);
        return true;
    }
}
