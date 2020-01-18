import characters.*;
import components.ArmourType;
import components.HerbalTea;
import components.WeaponType;
import creatures.Ogre;
import game.Game;
import rooms.Room;
import characters.Healer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GameRunner {


    public static void main(String[] args) throws InterruptedException {

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
        ArrayList<Player> party;

        game = new Game();

        party = game.getParty();


        room1 = new Room();
        room2 = new Room();
        room3 = new Room();

        alice = new Alice("Alice", 50, "Curiouser and curiouser!", WeaponType.AXE);
        knight = new Knight("Sir Killalot", 150, "'Your Mother smells of Elderberries', shouts Sir Killalot", WeaponType.SWORD, ArmourType.ADAMANTIUM);
        knight2 = new Knight("Sir Jamie", 150, "'Swish!', exclaimed Sir Jamie", WeaponType.SWORD, ArmourType.ADAMANTIUM);
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
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\nGood. Now select a companion for Alice.");
        System.out.println("1. Knight | 2. Cleric");
        Scanner scanner = new Scanner(System.in);
        int companionNumber = scanner.nextInt();
        game.addPlayer(alice);
        Player companion;

        switch (companionNumber) {
            case 1:
                companion = knight;
                game.addPlayer(knight);
            case 2:
                companion = cleric;
                game.addPlayer(cleric);
            default:
                companion = knight;
                game.addPlayer(knight);
        }

        game.addPlayer(alice);
        game.addPlayer(companion);
        System.out.println("Alice and " + companion.getName() + " enter the Killing Zone");

        //Game
        while (currentRoomNum < 4 && alice.checkIfAlive()) {
            switch (currentRoomNum) {
                case 2:
                    currentRoom = room2;
                    break;
                case 3:
                    currentRoom = room3;
                    break;
            }
            Player enemy = currentRoom.getEnemy();
            System.out.println("\nWhile entering room " + currentRoomNum + ", Alice and " + companion.getName() + " are suddenly accosted by ... " + enemy.getName() + "!");
            TimeUnit.SECONDS.sleep(2);
            System.out.print("\033[H\033[2J");
            System.out.println("\nFIGHT!\n");
            TimeUnit.SECONDS.sleep(2);

            System.out.println("\nAs " + enemy.getName() + " approaches, Alice decides to ...");
            TimeUnit.SECONDS.sleep(1);

            //Fighting Loop Starts
            while (currentRoom.isLocked() && alice.checkIfAlive()) {
                System.out.println("\n1. Attack | 2. Talk to a Caterpillar");
                int firstAliceChoice = scanner.nextInt();
                if (firstAliceChoice == 1) {
                    alice.attack(enemy);
                    System.out.println("\nAlice attacks with " + alice.getWeapon() + " for 15 damage");
                } else {
                    System.out.println("\n... that was not effective ...");
                }
                TimeUnit.SECONDS.sleep(2);

                if (enemy.checkIfAlive() == false) {
                    System.out.println("\n" + enemy.getName() + " falls to the floor. The door across the room unlocks");
                    currentRoom.unlockExit(enemy);
                    currentRoomNum += 1;

                } else {
                    if (enemy instanceof Cleric && alice.checkIfAlive()) {
                        ((Healer) cleric).heal(enemy, herbalTea);
                        System.out.println("\n" + enemy.getName() + " uses a herbal tea to repair herself by 5 HP");
                    }
                    if (enemy instanceof Fighter && alice.checkIfAlive()) {
                        party = game.getParty();
                        Player companionToAttack = game.getRandomCompanion(party);
                        ((Fighter) enemy).attack(companionToAttack);
                        System.out.println("\n" + enemy.getCatchPhrase() + " while attacking " + companionToAttack.getName() + " with a " + ((Fighter) enemy).getWeapon().getName() + " for " + ((Fighter) enemy).getWeapon().getDamage() + " damage.");
                    }
                }
                TimeUnit.SECONDS.sleep(2);

                if (companion.checkIfAlive() || alice.checkIfAlive()) {
                    ((Fighter) knight).attack(enemy);
                    System.out.println("\n" + companion.getCatchPhrase() + " while attacking " + enemy.getName());
                    if (enemy.checkIfAlive() == false) {
                        currentRoom.unlockExit(enemy);
                        System.out.println("\n" + enemy.getName() + " falls to the floor. The door across the room unlocks");
                        currentRoomNum += 1;
                    }
                }
                TimeUnit.SECONDS.sleep(3);
                System.out.print("\033[H\033[2J");
                System.out.println("\n\n\n\t=====================");
                System.out.println("\tAlice HP: " + alice.getCurrentHP());
                System.out.println("\t" + enemy.getName() + " HP: " +enemy.getCurrentHP());
                System.out.println("\t=====================\n\n\n");
                System.out.println("\npress any number for next round");
                int nextround = scanner.nextInt();
                System.out.print("\033[H\033[2J");
                //Fighting Loop ends Here


            }
        }
        if (alice.checkIfAlive()) {
            System.out.println("\n\t With all enemies vanquished, Alice leaves the Killing Floor, victorious once more.");
        } else {
            System.out.println("\n**** GAME OVER ***");
            System.out.println("\nAlice has died because of your incompetence.");
        }
    }



}
