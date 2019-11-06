package DungeonCrawler.Potions;

import DungeonCrawler.Entity;

public class PotionDef extends Potion {

    public PotionDef(String name, int value, Entity user, String effect) {
        this.name = name;
        this.value = value;
        this.user = user;
        this.effect = effect;
    }

    public PotionDef() {
        this.name = "Defense potion";
        this.value = 5;
        this.user = null;
        this.effect = "Raises defense by 5";
    }

    public boolean use(Entity user, Entity opponent) {
        user.setDefense(user.getDefense() + value);
        return true;
    }
}