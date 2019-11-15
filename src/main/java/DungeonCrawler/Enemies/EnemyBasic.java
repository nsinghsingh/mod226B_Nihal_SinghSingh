package DungeonCrawler.Enemies;

import DungeonCrawler.Entity;
import DungeonCrawler.Spells.Spell;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EnemyBasic extends Entity {

    public EnemyBasic(int hp, int mp, int attack, String name, ArrayList<Spell> spells) {
        this.hp = hp;
        this.mp = mp;
        this.attack = attack;
        this.name = name;
        this.spells = spells;
        this.defense = 0;
    }

    public EnemyBasic(Entity enemy) {
        this.hp = enemy.getHp();
        this.mp = enemy.getMp();
        this.attack = enemy.getAttack();
        this.name = enemy.getName();
        this.spells = enemy.getSpells();
        this.defense = enemy.getDefense();
    }

    public void getAttacked(int damage) {
        damage -= defense;
        if (damage < 0) {
            damage = 0;
        }
        System.out.print(name + " took " + damage + " damage!");
        hp -= damage;
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
    }

    public boolean attack(Entity opponent) {
        Random random = new Random();
        int luck = random.nextInt(100);
        if ( luck > 30) {
            opponent.getAttacked(attack);
            return true;
        } else {
            if (spells.size() > 0) {
                int index = random.nextInt(spells.size());
                Spell currentSpell = spells.get(index);
                currentSpell.setUser(this);
                System.out.print(name + " prepares himself to fire a spell!");
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                return currentSpell.fire(opponent);
            }
            else{
                opponent.getAttacked(attack);
                return true;
            }
        }
    }
}
