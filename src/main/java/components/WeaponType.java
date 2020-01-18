package components;

public enum WeaponType {

    SWORD(20, "Sword"),
    CLUB(10, "Club"),
    AXE(15, "Axe");

    private final int damage;
    private final String name;

    WeaponType(int damage, String name) {
        this.damage = damage;
        this.name = name;
    }

    public int getDamage() {
        return this.damage;
    }

    public String getName() {
        return this.name;
    }
}
