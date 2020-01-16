package interfaces;

import characters.Player;
import components.SpellType;

public interface IZap {

    public void attack(Player character, SpellType spell);
}
