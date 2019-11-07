package DungeonCrawler;

public class Normal extends DungeonCrawlerController{

    public Normal(Player player, Room currentRoom)
    {
        this.player = player;
        this.currentRoom = currentRoom;
    }

    public void displayOptions()
    {
        System.out.print("1.Health = " + player.getHp() + " ");
        System.out.print("2.Magic = " + player.getMp() + " ");
        System.out.print("3.Move ");
        System.out.println("4.Loot");
        String input = scanner.nextLine();
        if (input.equals("3"))
        {
            System.out.println("Which way do you want to go? Up, down, left or right?");
            input = scanner.nextLine();
            player.move(input, currentRoom);
        }
        else if (input.equals("4"))
        {
            player.loot();
        }
        else
        {
            displayOptions();
        }
    }

    public void isFighting()
    {
        if (currentRoom.getEnemies().size() > 0)
        {
            Fight fight = new Fight(player, currentRoom);
            fight.isFighting();
        }
        else
        {
            System.out.println("You are standing alone in a room. What would you like to do?");
            displayOptions();
        }
    }

}
