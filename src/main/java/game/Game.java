package game;

import characters.Cleric;
import characters.Knight;
import characters.Player;
import components.ArmourType;
import components.WeaponType;
import rooms.Room;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    public ArrayList<Player> party;
    public ArrayList<Room> rooms;
    public boolean winStatus;

    public Game() {
        this.party = new ArrayList<Player>();
        this.rooms = new ArrayList<Room>();
        this.winStatus = false;
    }

    public boolean isGameWon() {
        return this.winStatus;
    }

    public void win() {
        this.winStatus = true;
    }

    public ArrayList<Player> getParty() {
        ArrayList<Player> partyCopy = new ArrayList<Player>(party);
        return partyCopy;
    }
    public ArrayList<Room> getRooms() {
        ArrayList<Room> roomsCopy = new ArrayList<Room>(rooms);
        return roomsCopy;
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void addPlayer(Player player) {
        this.party.add(player);
    }

    public Player getRandomCompanion(ArrayList<Player> party) {
        int partySize = party.size();
        Random randomNum = new Random();
        int index = randomNum.nextInt(2);
        Player companion = party.get(index);
        return companion;
    }
}
