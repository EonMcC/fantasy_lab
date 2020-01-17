import characters.Alice;
import characters.Cleric;
import characters.Knight;
import characters.Player;
import components.ArmourType;
import components.WeaponType;
import game.Game;
import rooms.Room;

import java.util.Scanner;

public class GameRunner {


    public static void main(String[] args) {

        //Object Set Up
        Game game;

        Room room1;
        Room room2;
        Room room3;

        Alice alice;
        Knight knight;
        Cleric cleric;

        game = new Game();

        room1 = new Room();
        room2 = new Room();
        room3 = new Room();

        alice = new Alice("Alice", 300, "Curiouser and curiouser!", WeaponType.AXE);
        knight = new Knight("Sir Killalot", 150, "Stabby stabby", WeaponType.SWORD, ArmourType.ADAMANTIUM);
        cleric = new Cleric("Florence", 50, "Yir healed!");

        //Game Variables
        int currentRoom  = 1;

        //Set Up
        game.addRoom(room1);
        game.addRoom(room2);
        game.addRoom(room3);

        room1.addEnemy(cleric);

        //Game Intro
        System.out.println("Ready Player One?");
        System.out.println("Good. Now select a companion for Alice.");
        System.out.println("1. Knight | 2. Cleric");
        Scanner scanner = new Scanner(System.in);
        int companionNumber = scanner.nextInt();
        Player companion = game.convertNumberToCharacter(companionNumber);
        game.addPlayer(alice);
        game.addPlayer(companion);
        System.out.println("Alice and " + companion.getName() + " enter the Killing Zone");

        //Game
        Console.out.println(currentRoom);


    }



}
