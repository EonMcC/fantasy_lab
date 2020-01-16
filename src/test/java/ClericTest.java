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
        cleric = new Cleric("Florence", 50, "You're healed!", herbalTea);
    }

    @Test
    public void canGetName() {
        assertEquals("Florence", cleric.getName());
    }

}
