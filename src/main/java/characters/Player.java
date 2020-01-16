package characters;

public abstract class Player {

    private String name;
    private int hp;
    private String catchPhrase;

    public Player(String name, int hp, String catchPhrase) {
        this.name = name;
        this.hp = hp;
        this.catchPhrase = catchPhrase;
    }


}
