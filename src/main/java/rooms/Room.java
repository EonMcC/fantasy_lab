package rooms;

import characters.Player;
import characters.Warlock;

public class Room {

    private Player player;
    private Boolean exitLocked;

    public Room() {
        this.player = null;
        this.exitLocked = true;
    }

    public void addEnemy(Player enemy) {
        this.player = enemy;
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
