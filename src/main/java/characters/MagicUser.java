package characters;

import java.util.ArrayList;

public abstract class MagicUser extends Player {

    private ArrayList<Spell> spells;
    private Creature creature;

    public MagicUser(String name, int maxHP, String catchPhrase, Creature creature) {
        super(name, maxHP, catchPhrase);
        this.spells = new ArrayList<Spell>();
        this.creature = creature;
    }
}
