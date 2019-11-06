package DungeonCrawler;

import java.util.function.Consumer;

public class Potion extends Item{

    private Consumer<Entity> effectFunction;

    public Potion(String name, int value, Entity user, String effect, Consumer<Entity> effectFunction) {
        this.name = name;
        this.value = value;
        this.user = user;
        this.effect = effect;
        this.effectFunction = effectFunction;
    }

    public boolean use(Entity user) {
        effectFunction.accept(user);
        return true;
    }
}
