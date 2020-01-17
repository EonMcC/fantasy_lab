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
            int baseDamage = this.weapon.getDamage();
            if (character instanceof MagicUser || character instanceof Knight) {

                if (character instanceof MagicUser) {
                    double defence = ((MagicUser) character).getCreature().getDefence();
                    double damage = baseDamage * defence;
                    character.loseHP(damage);
                }

                if (character instanceof Knight) {
                    int damage = (int) (this.weapon.getDamage() * ((Knight) character).getArmour().getDefence());
                    character.loseHP(damage);
                }
            }
            else  {
                int damage = this.weapon.getDamage();
                character.loseHP(damage);
            }
        }
    }

