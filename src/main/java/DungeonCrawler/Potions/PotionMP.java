package DungeonCrawler.Potions;

import DungeonCrawler.Entity;

public class PotionMP extends Potion {

    public PotionMP(String name, int value, Entity user, String effect) {
        this.name = name;
        this.value = value;
        this.user = user;
        this.effect = effect;
    }

    public PotionMP() {
        this.name = "Mana potion";
        this.value = 25;
        this.user = null;
        this.effect = "Raises mana by 25";
    }

    public boolean use(Entity user, Entity opponent) {
        user.setMp(user.getMp() + value);
        return true;
    }
}