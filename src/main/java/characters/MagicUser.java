package characters;

import components.SpellType;
import creatures.Creature;
import interfaces.IZap;


import java.util.ArrayList;


public abstract class MagicUser extends Player implements IZap {

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

    public void setCreature(Creature creature) {
        this.creature = creature;
    }

    public void addSpell(SpellType spell) {
        this.spells.add(spell);
    }

    public void attack(Player character, SpellType spell) {
        if(this.spells.contains(spell)) {
            if (character instanceof MagicUser) {
                int damage = (int)(spell.getDamage() * ((MagicUser) character).getCreature().getDefence());
                character.loseHP(damage);
            }
            else {
                int damage = spell.getDamage();

            character.loseHP(damage);
            }
        }
    }
}
