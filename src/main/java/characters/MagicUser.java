package characters;

import components.SpellType;
import creatures.Creature;
import creatures.Ogre;

import java.util.ArrayList;
import java.util.Collection;

public abstract class MagicUser extends Player {

    private ArrayList<SpellType> spells;
    private Creature creature;

    public MagicUser(String name, int maxHP, String catchPhrase, Creature creature) {
        super(name, maxHP, catchPhrase);
        this.spells = new ArrayList<SpellType>();
        this.creature = creature;
    }

    public ArrayList<SpellType> getSpells() {
        ArrayList<SpellType> spellList = new ArrayList<SpellType>(spells);
        return spellList;
    }

    public Creature getCreature() {
        return this.creature;
    }
}
