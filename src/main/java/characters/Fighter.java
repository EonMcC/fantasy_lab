package characters;

import components.SpellType;
import components.WeaponType;

public abstract class Fighter extends Player {

    private WeaponType weapon;

    public Fighter(String name, int maxHP, String catchPhrase, WeaponType weapon) {
        super(name, maxHP, catchPhrase);
        this.weapon = weapon;
    }

    public WeaponType getWeapon() {
        return this.weapon;
    }

    public void setWeapon(WeaponType weapon) {
        this.weapon = weapon;
    }

    public void attack(Player character) {

            if (character instanceof MagicUser) {
                int damage = (int)(this.weapon.getDamage() * ((MagicUser) character).getCreature().getDefence());
                character.loseHP(damage);
            }

            if (character instanceof Knight) {
                int damage = (int)(this.weapon.getDamage() * ((Knight) character).getArmour().getDefence());
                character.loseHP(damage);
            }
            else {
                int damage = this.weapon.getDamage();

                character.loseHP(damage);
            }
        }
    }

