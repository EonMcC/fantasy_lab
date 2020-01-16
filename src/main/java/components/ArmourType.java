package components;

public enum ArmourType {

    GOLD(0.9),
    IRON(0.7),
    ADAMANTIUM(0.5);


    private final double defence;

    ArmourType(double defence) {
        this.defence = defence;
    }

    public double getDefence() {
        return this.defence;
    }
}
