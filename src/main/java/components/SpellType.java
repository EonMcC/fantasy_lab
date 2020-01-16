package components;

public enum SpellType {

    FIREBOLT(20),
    POISON(5),
    LIGHTNINGSTRIKE(15);

    private final int damage;

    SpellType(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }
}
