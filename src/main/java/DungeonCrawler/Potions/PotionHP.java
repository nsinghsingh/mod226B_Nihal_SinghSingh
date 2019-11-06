package DungeonCrawler.Potions;

import DungeonCrawler.Entity;

public class PotionHP extends Potion {

    public PotionHP(String name, int value, Entity user, String effect) {
        this.name = name;
        this.value = value;
        this.user = user;
        this.effect = effect;
    }

    public PotionHP() {
        this.name = "Health potion";
        this.value = 25;
        this.user = null;
        this.effect = "Raises health by 25";
    }

    public boolean use(Entity user, Entity opponent) {
        user.setHp(user.getHp() + value);
        return true;
    }
}
