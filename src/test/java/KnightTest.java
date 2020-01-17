import characters.Cleric;
import characters.Knight;
import characters.Wizard;
import components.ArmourType;
import components.SpellType;
import components.WeaponType;
import creatures.Dragon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    private Knight knight;
    private Cleric cleric;
    private Wizard wizard;
    private Dragon dragon;

    @Before
    public void before() {
        knight = new Knight("Sir Killalot", 150, "Stabby stabby", WeaponType.SWORD, ArmourType.ADAMANTIUM);
        dragon = new Dragon("Snarly", 0.5, 25);
        wizard = new Wizard("Harry", 50, "I'm a what?", dragon);
        cleric = new Cleric("Florence", 50, "Yir healed!");
    }

    @Test
    public void canGetName() {
        assertEquals("Sir Killalot", knight.getName());
    }

    @Test
    public void canReturnMaxHP() {
        assertEquals(150, knight.getMaxHP());
    }

    @Test
    public void canReturnCatchPhrase() {
        assertEquals("Stabby stabby", knight.getCatchPhrase());
    }

    @Test
    public void canReturnCurrentHP() {
        assertEquals(150, knight.getCurrentHP(), 0.01);
    }

    @Test
    public void canLoseHP() {
        knight.loseHP(10);
        assertEquals(140.0, knight.getCurrentHP(), 0.01);
    }
    //
    @Test
    public void canGainHP() {
        knight.loseHP(15);
        knight.gainHP(10);
        assertEquals(145, knight.getCurrentHP(), 0.01);
    }

    @Test
    public void cannotHealMoreThanMaxHP() {
        knight.loseHP(10);
        knight.gainHP(20);
        assertEquals(150, knight.getCurrentHP(), 0.01);
    }

    @Test
    public void hasWeapon() {
        assertEquals(WeaponType.SWORD, knight.getWeapon());
    }

    @Test
    public void changeWeapon() {
        knight.setWeapon(WeaponType.AXE);
        assertEquals(WeaponType.AXE, knight.getWeapon());

    }@Test
    public void hasArmour() {
        assertEquals(ArmourType.ADAMANTIUM, knight.getArmour());
    }

    @Test
    public void changeArmour() {
        knight.setArmour(ArmourType.GOLD);
        assertEquals(ArmourType.GOLD, knight.getArmour());
    }

    @Test
    public void canAttack() {
        knight.attack(cleric);
        assertEquals(30, cleric.getCurrentHP(), 0.01);
    }

    @Test
    public void magicUserOpponentCanDefend() {
        knight.attack(wizard);
        assertEquals(40.00, wizard.getCurrentHP(), 0.01);
    }

}

