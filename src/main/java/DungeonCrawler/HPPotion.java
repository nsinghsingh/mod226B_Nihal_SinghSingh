package DungeonCrawler;

public class HPPotion extends Item{

    public HPPotion(String name, int value, Entity user, String effect) {
        this.name = name;
        this.value = value;
        this.user = user;
        this.effect = effect;
    }

    public boolean use(Entity user) {
        user.setHp(user.getHp() + value);
        return true;
    }
}
