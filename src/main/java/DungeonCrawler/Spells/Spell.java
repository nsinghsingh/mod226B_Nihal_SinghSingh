package DungeonCrawler.Spells;

import DungeonCrawler.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Spell {

    protected Entity user;
    protected int cost;
    protected int value;
    protected String attackCry;
    protected String name;

    public Spell(int cost, int value, String attackCry, String name) {
        this.cost = cost;
        this.value = value;
        this.attackCry = attackCry;
        this.name = name;
    }

    public Spell(Spell spell){
        this.cost = spell.getCost();
        this.value = spell.getValue();
        this.attackCry = spell.getAttackCry();
        this.name = spell.getName();
    }
    public abstract boolean fire(Entity opponent);
}
