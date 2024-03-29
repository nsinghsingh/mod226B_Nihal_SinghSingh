package DungeonCrawler;

public class Normal extends DungeonCrawlerController {

    public Normal(Player player, Room currentRoom) {
        this.player = player;
        this.currentRoom = currentRoom;
    }

    public void displayOptions() {
        player.setAttack(player.getRealAttack());
        player.setDefense(player.getRealDefense());
        System.out.print("1.Health = " + player.getHp() + " ");
        System.out.print("2.Magic = " + player.getMp() + " ");
        System.out.print("3.Defense = " + player.getDefense() + " ");
        System.out.print("4.Move ");
        System.out.print("5.Loot ");
        System.out.println("6.Items");
        String input = scanner.nextLine();
        if (input.equals("4")) {
            System.out.println("Which way do you want to go? Up, down, left or right?");
            input = scanner.nextLine();
            player.move(input, currentRoom);
        } else if (input.equals("5")) {
            player.loot();
        } else if (input.equals("6")) {
            Item item = player.chooseItem();
            boolean hasActed = item.use(player, null);
            if (hasActed) {
                player.getItems().remove(item);
            }
        } else {
            displayOptions();
        }
    }

    public void isFighting() {
        if (currentRoom.getEnemies().size() > 0) {
            Fight fight = new Fight(player, currentRoom);
            fight.isFighting();
        } else {
            System.out.println("You are standing alone in a room. What would you like to do?");
            displayOptions();
        }
    }

}
