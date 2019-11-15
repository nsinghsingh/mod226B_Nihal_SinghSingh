package DungeonCrawler.Potions;

import DungeonCrawler.Entity;

public class PotionBlind extends Potion {

    public PotionBlind(String name, int value, Entity user, String effect) {
        this.name = name;
        this.value = value;
        this.user = user;
        this.effect = effect;
    }

    public PotionBlind() {
        this.name = "Blinding potion";
        this.value = 10;
        this.user = null;
        this.effect = "Stuns enemies for 1 turn and hurts them";
    }

    public boolean use(Entity user, Entity opponent) {
        opponent.getAttacked(value);
        return false;
    }
}