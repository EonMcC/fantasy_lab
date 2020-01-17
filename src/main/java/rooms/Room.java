package rooms;

import characters.Player;
import characters.Warlock;

public class Room {

    private Player player;
    private Boolean exit;

    public Room(Player player) {
        this.player = player;
        this.exit = false;
    }


    public Player getEnemy() {
        return this.player;
    }
}
