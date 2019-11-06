package DungeonCrawler.Potions;

import DungeonCrawler.Entity;
import DungeonCrawler.Item;

public abstract class Potion extends Item {

    public abstract boolean use(Entity user, Entity opponent);
}
