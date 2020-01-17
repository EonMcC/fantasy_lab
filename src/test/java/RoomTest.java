import characters.Warlock;
import creatures.Ogre;
import org.junit.Before;
import org.junit.Test;
import rooms.Room;

import static junit.framework.TestCase.assertEquals;

public class RoomTest {

    private Room room;
    private Ogre ogre;
    private Warlock warlock;

    @Before
    public void before() {
        ogre = new Ogre("Oggy", 0.4, 15);
        warlock = new Warlock("Harrion", 75, "You've been locked", ogre);
        room = new Room();
    }

    @Test
    public void canAddEnemy() {
        room.addEnemy(warlock);
        assertEquals(warlock, room.getEnemy());
    }

    @Test
    public void exitStartsLocked() {
        assertEquals(true, room.isLocked());
    }

    @Test
    public void canUnlockExit() {
        warlock.killPlayer();
        room.unlockExit(warlock);
        assertEquals(false, room.isLocked());
    }

    @Test
    public void exitUnlocksWhenEnemyDead() {
        warlock.killPlayer();
        room.unlockExit(warlock);
        assertEquals(false, room.isLocked());
    }

}
