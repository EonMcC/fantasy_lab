package game;

import characters.Player;
import rooms.Room;

import java.util.ArrayList;

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
        return this.party;
    }
    public ArrayList<Room> getRooms() {
        return this.rooms;
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void addPlayer(Player player) {
        this.party.add(player);
    }
}
