package components;

public enum WeaponType {

    SWORD(20),
    CLUB(10),
    AXE(15);

    private final int damage;

    WeaponType(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return this.damage;
    }
}
