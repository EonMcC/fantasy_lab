import characters.Alice;
import characters.Knight;
import characters.Player;
import components.ArmourType;
import components.WeaponType;
import game.Game;
import org.junit.Before;
import org.junit.Test;
import rooms.Room;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

public class GameTest {

    private Game game;
    private Room room;
    private Player knight;
    private ArrayList<Player> party;
    private Alice alice;

    @Before
    public void before() {
        alice = new Alice("Alice", 50, "Curiouser and curiouser!", WeaponType.AXE);
        game = new Game();
        knight = new Knight("Sir Killalot", 150, "Stabby stabby", WeaponType.SWORD, ArmourType.ADAMANTIUM);
        room = new Room();
        party = new ArrayList<Player>();

    }

    @Test
    public void gameStartsNotWon() {
        assertEquals(false, game.isGameWon());
    }

    @Test
    public void gameCanBeWon() {
        game.win();
        assertEquals(true, game.isGameWon());
    }

    @Test
    public void partyStartsEmpty() {
        assertEquals(0, game.getParty().size());
    }

    @Test
    public void roomsStartEmpty() {
        assertEquals(0, game.getRooms().size());
    }

    @Test
    public void canAddRoom() {
        game.addRoom(room);
        assertEquals(1, game.getRooms().size());
    }

    @Test
    public void canAddPlayer() {
        game.addPlayer(knight);
        assertEquals(1, game.getParty().size());
    }



}
