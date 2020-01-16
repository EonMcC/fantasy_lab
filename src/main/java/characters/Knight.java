package characters;

import components.ArmourType;
import components.WeaponType;

public class Knight extends Fighter{

    private ArmourType armour;

    public Knight(String name, int maxHP, String catchPhrase, WeaponType weapon, ArmourType armour) {
        super(name, maxHP, catchPhrase, weapon);
        this.armour = armour;
    }

    public ArmourType getArmour() {
        return this.armour;
    }

    public void setArmour(ArmourType armour) {
        this.armour = armour;
    }
}
