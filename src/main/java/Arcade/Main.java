package Arcade;

import java.util.Scanner;

public class Main {

    Arcadebox[] games = new Arcadebox[]{new ArcadeboxTicTacToe(), new ArcadeboxAdventureZone(), new ArcadeboxDungeonCrawler()};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        System.out.print("Welcome to the arcade!");
        String input = scanner.nextLine();
        System.out.println("Here you can play three different games:");
        System.out.println("Tic Tac Toe against an AI or a second player,");
        System.out.println("a choose your own adventure game with multiple endings");
        System.out.print("or the most advanced game of them all, the Dungeon Crawler.");
        input = scanner.nextLine();
        while (true){
            System.out.println("So which game will it be? 1. Tic Tac Toe 2. Adventure Zone 3. Dungeon Crawler");
            try{
                int index = scanner.nextInt();
                main.games[index].start(args);
            }catch (Exception e){
                System.out.println("Could you please give in a number to choose a game?");
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
