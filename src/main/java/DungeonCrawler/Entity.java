package DungeonCrawler;

import DungeonCrawler.Spells.Spell;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Setter
@Getter

public abstract class Entity {

    protected int hp;
    protected int mp;
    protected int attack;
    protected int defense;
    protected String name;
    protected ArrayList<Spell> spells;

    public abstract void getAttacked(int damage);

    public abstract boolean attack(Entity opponent);
}
