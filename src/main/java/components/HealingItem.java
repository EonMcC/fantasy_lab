package components;

public abstract class HealingItem {

    private int healingPower;

    public HealingItem(int healingPower) {
        this.healingPower = healingPower;
    }

    public int getHealingPower() {
        return this.healingPower;
    }
}
