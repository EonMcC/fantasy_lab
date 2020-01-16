package creatures;

public abstract class Creature {

    private String name;
    private double defence;
    private int attack;

    public Creature(String name, double defence, int attack) {
        this.name = name;
        this.defence = defence;
        this.attack = attack;
    }

    public String getName() {
        return this.name;
    };

    public double getDefence() {
        return this.defence;
    };

    public int getAttack() {
        return this.attack;
    };
}
