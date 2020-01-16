import characters.Warlock;
import creatures.Ogre;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WarlockTest {

    private Warlock warlock;
    private Ogre ogre;

    @Before
    public void before() {
        ogre = new Ogre("Oggy", 0.4, 15);
        warlock = new Warlock("Harrion", 75, "You've been locked", ogre);
    }

    @Test
    public void canGetName() {
        assertEquals("Harrion", warlock.getName());
    }

    @Test
    public void canReturnMaxHP() {
        assertEquals(75, warlock.getMaxHP());
    }

    @Test
    public void canReturnCatchPhrase() {
        assertEquals("You've been locked", warlock.getCatchPhrase());
    }

    @Test
    public void canReturnCurrentHP() {
        assertEquals(75, warlock.getCurrentHP());
    }

    @Test
    public void canLoseHP() {
        warlock.loseHP(10);
        assertEquals(65, warlock.getCurrentHP());
    }
    //
    @Test
    public void canGainHP() {
        warlock.loseHP(15);
        warlock.gainHP(10);
        assertEquals(70, warlock.getCurrentHP());
    }

    @Test
    public void cannotHealMoreThanMaxHP() {
        warlock.loseHP(10);
        warlock.gainHP(20);
        assertEquals(75, warlock.getCurrentHP());
    }

    @Test
    public void spellsShouldStartEmpty() {
        assertEquals(0, warlock.getSpells().size());
    }

    @Test
    public void hasMythicalCreature() {
        assertEquals(ogre, warlock.getCreature());
    }
}
