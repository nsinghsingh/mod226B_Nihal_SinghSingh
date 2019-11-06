package DungeonCrawler.Spells;

import DungeonCrawler.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Spell {

    protected Entity user;
    protected int cost;

    protected int damage;
    protected String attackCry;
    protected String name;

    public abstract boolean fire(Entity opponent, Entity user);
}
