package characters;

import components.HealingItem;

public abstract class Healer extends Player {

    private HealingItem healingItem;

    public Healer(String name, int hp, String catchPhrase, HealingItem healingItem) {
        super(name, hp, catchPhrase);
        this.healingItem = healingItem;
    }
}
