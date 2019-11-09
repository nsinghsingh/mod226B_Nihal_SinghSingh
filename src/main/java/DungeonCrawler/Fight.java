package DungeonCrawler;

import DungeonCrawler.Spells.Spell;

import java.util.ArrayList;

public class Fight extends DungeonCrawlerController {

    private ArrayList<Entity> enemies;

    public Fight(Player player, Room currentRoom) {
        setPlayer(player);
        setCurrentRoom(currentRoom);
        enemies = currentRoom.getEnemies();
    }

    public void displayOptions() {
        boolean hasActed;
        System.out.print("1.Health = " + player.getHp() + " ");
        System.out.print("2.Magic = " + player.getMp() + " ");
        System.out.print("3.Attack ");
        System.out.print("4.Run ");
        System.out.println("5.Items");
        String input = scanner.nextLine();
        if ("2".equals(input)) {
            Entity opponent = player.targetEnemy(enemies);
            Spell currentSpell = player.chooseSpell(player.spells);
            currentSpell.setUser(player);
            hasActed = currentSpell.fire(opponent);
            if (opponent.getHp() <= 0) {
                System.out.println("You defeated " + opponent.getName());
                currentRoom.getEnemies().remove(opponent);
            }
        } else if ("3".equals(input)) {
            Entity opponent = player.targetEnemy(enemies);
            hasActed = player.attack(opponent);
        } else if ("4".equals(input)) {
            hasActed = player.run(currentRoom);
        } else if ("5".equals(input)) {
            Entity opponent = player.targetEnemy(enemies);
            Item item = player.chooseItem();
            hasActed = item.use(player, opponent);
            if (hasActed) {
                player.getItems().remove(item);
            }
        } else {
            hasActed = false;
        }
        if (!hasActed && enemies.size() > 0) {
            System.out.println("Your attack or whatever you chose didn't work!");
            displayOptions();
        } else {
            for (int i = 0; i < enemies.size(); i++) {
                enemies.get(i).attack(player);
            }
        }
    }

    public void isFighting() {
        if (player.getHp() <= 0) {
            gameOver();
        } else {
            System.out.println("You are fighting some monsters. What would you like to do?");
            displayOptions();
        }
    }


    public void gameOver() {
        System.out.println("You died :(");
        player = null;
    }
}
