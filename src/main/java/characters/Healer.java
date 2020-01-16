package characters;

import components.HealingItem;

public abstract class Healer extends Player {

    private HealingItem healingItem;

    public Healer(String name, int maxHP, String catchPhrase, HealingItem healingItem) {
        super(name, maxHP, catchPhrase);
        this.healingItem = healingItem;
    }
}
