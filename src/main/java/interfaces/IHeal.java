package interfaces;

import characters.Player;
import components.HealingItem;

public interface IHeal {

    public String heal(Player character, HealingItem healingItem);
}
