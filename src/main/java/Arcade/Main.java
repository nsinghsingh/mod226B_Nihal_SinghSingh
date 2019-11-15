package Arcade;

import java.util.Scanner;

public class Main {

    private Arcadebox[] games = new Arcadebox[]{new ArcadeboxTicTacToe(), new ArcadeboxAdventureZone(), new ArcadeboxDungeonCrawler()};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        System.out.print("Welcome to the arcade!");
        String input = scanner.nextLine();
        System.out.println("Here you can play three different games:");
        System.out.print("Tic Tac Toe against an AI or a second player,");
        System.out.print(" a choose your own adventure game with multiple endings");
        System.out.print(" or the most advanced game of them all, the Dungeon Crawler.");
        input = scanner.nextLine();
        while (true){
            System.out.println("So which game will it be? 1. Tic Tac Toe 2. Adventure Zone 3. Dungeon Crawler");
            try{
                scanner = new Scanner(System.in);
                int index = scanner.nextInt();
                System.out.println("Are you sure you want to play this game? (yes or no)");
                scanner = new Scanner(System.in);
                input = scanner.nextLine();
                if (input.equals("yes")){
                    main.games[index-1].start();
                }
            }catch (Exception e){
                System.out.println(e.getLocalizedMessage());
            }
            System.out.println("Would you like to keep on playing? (yes or no)");
            scanner = new Scanner(System.in);
            input = scanner.nextLine();
            if (input.equals("no")){
                System.out.println("Goodbye");
                break;
            }
        }
    }
}
