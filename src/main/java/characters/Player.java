package characters;

public abstract class Player {

    private String name;
    private int maxHP;
    private double currentHP;
    private String catchPhrase;
    private boolean isAlive;

    public Player(String name, int maxHP, String catchPhrase) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
        this.catchPhrase = catchPhrase;
        this.isAlive = true;
    }

    public String getName() {
        return this.name;
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    public double getCurrentHP() {
        return this.currentHP;
    }

    public String getCatchPhrase() {
        return this.catchPhrase;
    }

    public void loseHP(double damage) {
        this.currentHP -= damage;
        if (currentHP <= 0) {
            killPlayer();
        }
    }

    public void gainHP(int heal) {
        if(heal + this.currentHP < this.maxHP) {
            this.currentHP += heal;
        }
        else {
            this.currentHP = this.maxHP;
        }
    }

    public boolean checkIfAlive() {
        return this.isAlive;
    }

    public void killPlayer() {
        this.isAlive = !this.isAlive;
    }
}
