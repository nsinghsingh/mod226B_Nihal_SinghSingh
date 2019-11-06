package DungeonCrawler;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Item {

    protected String name;
    protected int value;
    protected Entity user;
    protected String effect;

    public abstract boolean use(Entity user);

}
