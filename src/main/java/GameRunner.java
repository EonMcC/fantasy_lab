import characters.*;
import components.ArmourType;
import components.HerbalTea;
import components.WeaponType;
import creatures.Ogre;
import game.Game;
import rooms.Room;
import characters.Healer;

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
        Knight knight2;
        Knight knight3;
        Cleric cleric;
        Ogre ogre;
        Warlock warlock;
        HerbalTea herbalTea;

        game = new Game();

        room1 = new Room();
        room2 = new Room();
        room3 = new Room();

        alice = new Alice("Alice", 300, "Curiouser and curiouser!", WeaponType.AXE);
        knight = new Knight("Sir Killalot", 150, "Stabby stabby", WeaponType.SWORD, ArmourType.ADAMANTIUM);
        knight2 = new Knight("Sir Jamie", 150, "Swish!", WeaponType.SWORD, ArmourType.ADAMANTIUM);
        knight3 = new Knight("Sir Squanch", 150, "Squanch!, squanched Sir Squanch!", WeaponType.SWORD, ArmourType.ADAMANTIUM);
        herbalTea = new HerbalTea(5);
        cleric = new Cleric("Florence", 50, "'Yir healed!', yelled Florence.");
        ogre = new Ogre("Oggy", 0.4, 15);
        warlock = new Warlock("Harrion", 75, "You've been locked", ogre);

        //Game Variables
        int currentRoomNum = 1;
        Room currentRoom = room1;


        //Set Up
        game.addRoom(room1);
        game.addRoom(room2);
        game.addRoom(room3);

        room1.addEnemy(cleric);
        room2.addEnemy(knight2);
        room3.addEnemy(knight3);

        cleric.addHealingItem(herbalTea);

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
        while (currentRoomNum < 4) {
            switch (currentRoomNum) {
                case 2:
                    currentRoom = room2;
                    break;
                case 3:
                    currentRoom = room3;
                    break;
            }
            Player enemy = currentRoom.getEnemy();
            System.out.println("Entering room " + currentRoomNum + ", Alice and " + companion.getName() + " are suddenly accosted by ... " + enemy.getName() + "!");
            System.out.println("\nFIGHT!\n");

            System.out.println("As " + enemy.getName() + " approaches, Alice decides to ...");

            //Fighting Loop Starts
            while (currentRoom.isLocked()) {
                System.out.println("\n1. Attack | 2. Talk to a Caterpillar");
                int firstAliceChoice = scanner.nextInt();
                if (firstAliceChoice == 1) {
                    alice.attack(enemy);
                    System.out.println("Alice attacks with " + alice.getWeapon() + " for 15 damage");
                } else {
                    System.out.println("... that was not effective ...");
                }

                if (enemy.checkIfAlive() == false) {
                    System.out.println(enemy.getName() + " falls to the floor. The door across the room unlocks");
                    currentRoom.unlockExit(enemy);
                    currentRoomNum += 1;

                } else {
                    if (enemy instanceof Cleric) {
                        ((Healer) cleric).heal(enemy, herbalTea);
                        System.out.println(enemy.getName() + " uses a herbal tea to repair herself by 5 HP");
                    }
                    if (enemy instanceof Fighter) {
                        ((Fighter) enemy).attack(alice);
                        System.out.println(enemy.getName() + " attacks Alice with " + ((Fighter) enemy).getWeapon() + "for " + ((Fighter) enemy).getWeapon().getDamage() + " damage.");
                    }
                }

                if (companion.checkIfAlive()) {
                    ((Fighter) knight).attack(enemy);
                    System.out.println(companion.getCatchPhrase());
                    System.out.println(companion.getName() + " attacks");
                    if (enemy.checkIfAlive() == false) {
                        currentRoom.unlockExit(enemy);
                        System.out.println(enemy.getName() + " falls to the floor. The door across the room unlocks");
                        currentRoomNum += 1;
                    }
                }

                //Fighting Loop ends Here


            }
        }
        System.out.println("\t With all enemies vanquished, Alice leaves the Killing Floor, victorious once more.");
    }



}
