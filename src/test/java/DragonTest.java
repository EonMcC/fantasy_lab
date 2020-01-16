import creatures.Dragon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class DragonTest {

    private Dragon dragon;

    @Before
    public void before() {
        dragon = new Dragon("Snarly", 0.5, 25);
    }

    @Test
    public void hasName() {
        assertEquals("Snarly", dragon.getName());
    }

    @Test
    public void hasDefence() {
        assertEquals(0.5, dragon.getDefence(), 0.1);
    }

    @Test
    public void hasAttack() {
        assertEquals(25, dragon.getAttack());
    }
}
