package DungeonCrawler;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Spell {

    private Entity user;
    private int cost;
    private int damage;
    private String attackCry;
    private String name;

    public Spell(int cost, int damage, String attackCry, String name){
        this.cost = cost;
        this.damage = damage;
        this.attackCry = attackCry;
        this.name = name;
    }

    public boolean fire(Entity opponent){
        if (user.getMp() < cost){
            return false;
        }
        else{
            System.out.println(attackCry);
            opponent.setHp(opponent.getHp()-damage);
            user.setMp(user.getMp()-cost);
            return true;
        }
    }
}
