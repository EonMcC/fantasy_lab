package characters;

import components.HealingItem;
import interfaces.IHeal;

public class Cleric extends Healer implements IHeal{

    public Cleric(String name, int maxHP, String catchPhrase) {
        super(name, maxHP, catchPhrase);
    }

}
