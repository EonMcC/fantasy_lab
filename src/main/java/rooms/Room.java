package rooms;

import characters.Player;
import characters.Warlock;

public class Room {

    private Player player;
    private Boolean exitLocked;

    public Room(Player player) {
        this.player = player;
        this.exitLocked = true;
    }

    public Player getEnemy() {
        return this.player;
    }

    public boolean isLocked() {
        return this.exitLocked;
    }

    public void unlockExit(Player enemy) {
        if (enemy.checkIfAlive() == false) {
            this.exitLocked = !this.exitLocked;
        }
    }
}
