package DungeonCrawler;

import lombok.Getter;
import lombok.Setter;

import java.util.function.Consumer;

@Setter
@Getter
public class Spell {

    private Entity user;
    private int cost;
    private int damage;
    private String attackCry;
    private String name;
    private Consumer<Entity> effectFunction;

    public Spell(int cost, int damage, String attackCry, String name, Consumer<Entity> effectFunction){
        this.cost = cost;
        this.damage = damage;
        this.attackCry = attackCry;
        this.name = name;
        this.effectFunction = effectFunction;
    }

    public boolean fire(Entity opponent){
        if (user.getMp() < cost){
            return false;
        }
        else{
            System.out.println(attackCry);
            effectFunction.accept(opponent);
            user.setMp(user.getMp()-cost);
            return true;
        }
    }
}
