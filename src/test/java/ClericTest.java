import characters.Cleric;

import components.HerbalTea;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClericTest {

    private Cleric cleric;
    private HerbalTea herbalTea;

    @Before
    public void before() {
        herbalTea = new HerbalTea(5);
        cleric = new Cleric("Florence", 50, "Yir healed!", herbalTea);
    }

    @Test
    public void canGetName() {
        assertEquals("Florence", cleric.getName());
    }

    @Test
    public void canReturnMaxHP() {
        assertEquals(50, cleric.getMaxHP());
    }

    @Test
    public void canReturnCatchPhrase() {
        assertEquals("Yir healed!", cleric.getCatchPhrase());
    }

    @Test
    public void canReturnCurrentHP() {
        assertEquals(50, cleric.getCurrentHP());
    }

    @Test
    public void canLoseHP() {
        cleric.loseHP(10);
        assertEquals(40, cleric.getCurrentHP());
    }
//
    @Test
    public void canGainHP() {
        cleric.loseHP(15);
        cleric.gainHP(10);
        assertEquals(45, cleric.getCurrentHP());
    }

    @Test
    public void cannotHealMoreThanMaxHP() {
        cleric.loseHP(10);
        cleric.gainHP(20);
        assertEquals(50, cleric.getCurrentHP());
    }
}
