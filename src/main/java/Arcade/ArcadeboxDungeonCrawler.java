package Arcade;

import DungeonCrawler.DungeonTutorial;
import DungeonCrawler.Item;
import DungeonCrawler.Normal;
import DungeonCrawler.Player;
import DungeonCrawler.Spells.Spell;

import java.util.ArrayList;
import java.util.Scanner;

public class ArcadeboxDungeonCrawler {

    protected String intro = "Welcome to the dungeon. We hope you don't die too early.";
    private Normal beginning;
    private int level = 1;
    private Player player;

    public void start() {
        System.out.print(intro);
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.println("What is your name?");
        String name = scanner.nextLine();
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
                player.setCurrentroom(player.getDungeon()[0][0]);
        }

    }

    public void run() {
        while (true) {
            beginning.setCurrentRoom(player.getCurrentroom());
            beginning.isFighting();
            if (player.getHp() <= 0){
                beginning.isFighting();
                break;
            }
        }
    }

    public static void main(String[] args) {
        ArcadeboxDungeonCrawler dungeon = new ArcadeboxDungeonCrawler();
        dungeon.start();
        dungeon.beginning = new Normal(dungeon.player, dungeon.player.getCurrentroom());
        dungeon.run();
    }

}
