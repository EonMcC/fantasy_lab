package characters;

import components.HealingItem;
import interfaces.IHeal;

import java.util.ArrayList;

public abstract class Healer extends Player implements IHeal {

    private ArrayList<HealingItem> inventory;

    public Healer(String name, int maxHP, String catchPhrase) {
        super(name, maxHP, catchPhrase);
        this.inventory = new ArrayList<HealingItem>();
    }

    public ArrayList<HealingItem> getInventory() {
        ArrayList<HealingItem> list = new ArrayList<HealingItem>(inventory);
        return list;
    }

    public void addHealingItem(HealingItem healingItem) {
        this.inventory.add(healingItem);
    }

    public void removeHealingItem(HealingItem healingItem) {
        this.inventory.remove(healingItem);
    }

    public boolean hasItem(HealingItem item) {
        return this.inventory.contains(item);
    }

    public String heal(Player character, HealingItem healingItem) {
        if(this.hasItem(healingItem)) {
            int heal = healingItem.getHealingPower();
            character.gainHP(heal);

            this.removeHealingItem(healingItem);

            return this.getCatchPhrase();
        }
        return "You don't have that item";
    }
}
