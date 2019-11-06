package DungeonCrawler;

import java.util.Scanner;
import java.util.function.Consumer;

public class Armour extends Item {

    private int armourPiece;

    public Armour(String name, int value, Entity user, String effect, int armourPiece) {
        this.name = name;
        this.value = value;
        this.user = user;
        this.effect = effect;
        this.armourPiece = armourPiece;
    }

    public boolean use(Entity user, Entity opponent) {
        Item[] equipment;
        Player player;
        try {
            player = (Player) user;
            equipment = player.getEquipment();
        } catch (Exception e) {
            return false;
        }
        if (equipment[armourPiece] == null) {
            System.out.println("You have equipped " + name);
            player.getItems().remove(this);
            player.setDefense(player.getDefense() + value);
            equipment[armourPiece] = this;
            return true;
        } else {
            System.out.println("Would you like to switch " + equipment[armourPiece].name + " def: " + equipment[armourPiece].value + " for " + name + " def: " + value);
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("yes")) {
                player.getItems().add(equipment[armourPiece]);
                player.setDefense(player.getDefense() - equipment[armourPiece].value);
                player.getItems().remove(this);
                player.setDefense(player.getDefense() + value);
                equipment[armourPiece] = this;
                return true;
            }
            return false;
        }
    }

}
