package Arcade;

import DungeonCrawler.Dungeons.DungeonTutorial;
import DungeonCrawler.Item;
import DungeonCrawler.Normal;
import DungeonCrawler.Player;
import DungeonCrawler.Spells.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ArcadeboxDungeonCrawler extends Arcadebox{

    private Normal beginning;
    private int level = 1;
    private Player player;

    public ArcadeboxDungeonCrawler(){
        intro = "Welcome to the dungeon. This is a text based game in which you'll go through a square dungeon with 25 rooms.\n" +
                "The further you go, the more difficult the enemies will be. You'll be capable of collecting items, armour and using spells to defeat your enemies.\n" +
                "TIP: To choose an option use numbers except when moving.";
    }

    public void start() {
        System.out.print(intro);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("What is your name?");
        String name = scanner.nextLine();
        System.out.println("Which level do you want to play?");
        scanner.nextLine();
        System.out.print("Cool. We'll ignore your choice and load the first dungeon because it's the only one available");
        scanner.nextLine();
        ArrayList<Item> items = new ArrayList<>();
        ArrayList<Spell> spells = new ArrayList<>();
        switch (level) {
            case 1:
                DungeonTutorial level = new DungeonTutorial();
                items.add(level.registerItems().get("hp"));
                items.add(level.registerItems().get("mp"));
                spells.add(level.registerSpells().get("heal"));
                spells.add(level.registerSpells().get("dab"));
                spells.add(level.registerSpells().get("rest"));
                player = new Player(100, 100, 10, name, spells, items, level.generateDungeon());
                player.setCurrentRoom(player.getDungeon()[0][0]);
        }
        beginning = new Normal(player, player.getCurrentRoom());
        run();
    }

    public void run() {
        while (true) {
            beginning.setCurrentRoom(player.getCurrentRoom());
            beginning.isFighting();
            if (player.getHp() <= 0) {
                beginning.isFighting();
                stop();
                break;
            }
        }
    }

    public void stop() {
        beginning = null;
        player = null;
    }
}
