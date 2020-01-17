import characters.Cleric;

import components.HerbalTea;
import components.Runestone;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClericTest {

    private Cleric cleric;
    private HerbalTea herbalTea;

    @Before
    public void before() {
        herbalTea = new HerbalTea(5);
        cleric = new Cleric("Florence", 50, "Yir healed!");
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
        assertEquals(50, cleric.getCurrentHP(), 0.01);
    }

    @Test
    public void canLoseHP() {
        cleric.loseHP(10);
        assertEquals(40, cleric.getCurrentHP(), 0.01);
    }
//
    @Test
    public void canGainHP() {
        cleric.loseHP(15);
        cleric.gainHP(10);
        assertEquals(45, cleric.getCurrentHP(), 0.01);
    }

    @Test
    public void cannotHealMoreThanMaxHP() {
        cleric.loseHP(10);
        cleric.gainHP(20);
        assertEquals(50, cleric.getCurrentHP(), 0.01);
    }

    @Test
    public void inventoryStartsEmpty() {
        assertEquals(0, cleric.getInventory().size());
    }

    @Test
    public void canAddHealingItem() {
        Runestone runestone = new Runestone(25);
        cleric.addHealingItem(runestone);
        assertEquals(1, cleric.getInventory().size());
    }

    @Test
    public void canRemoveHealingItem() {
        cleric.addHealingItem(herbalTea);
        cleric.removeHealingItem(herbalTea);
    assertEquals(0, cleric.getInventory().size());
    }

    @Test
    public void hasHealingItem() {
        Runestone runestone = new Runestone(25);
        cleric.addHealingItem(herbalTea);
        assertTrue(cleric.hasItem(herbalTea));
        assertFalse(cleric.hasItem(runestone));
    }

    @Test
    public void canHeal() {
        cleric.addHealingItem(herbalTea);
        cleric.loseHP(20);
        cleric.heal(cleric, herbalTea);
        assertEquals(35, cleric.getCurrentHP(), 0.01);
        assertEquals(0, cleric.getInventory().size());
    }

    @Test
    public void healingReturnsCatchphrase() {
        cleric.addHealingItem(herbalTea);
        cleric.loseHP(20);
        assertEquals("Yir healed!", cleric.heal(cleric, herbalTea));
    }

    @Test
    public void cannotHeal() {
        assertEquals("You don't have that item", cleric.heal(cleric, herbalTea));
    }

    @Test
    public void playerStartsAlive() {
        assertEquals(true, cleric.checkIfAlive());
    }


}
