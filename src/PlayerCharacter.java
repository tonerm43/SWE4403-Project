public class PlayerCharacter extends Character {
    private static PlayerCharacter instance;

    private String name;
    private int health;
    private int attack;
    private int level;

    public static PlayerCharacter getInstance() {
        if (instance == null) {
            instance = new PlayerCharacter();
        }
        return instance;
    }

    private PlayerCharacter() {

    }

    public void reset() {
        name = null;
        health = 0;
        attack = 0;
        level = 0;
    }

    @Override
    public void characterFor(int level) {
        this.level = level;
        this.health = 100 + 25*(level-1);
        this.attack = 25 + 15*(level-1);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public int getAttack() {
        return attack;
    }

    @Override
    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return name + "," + health + "," + attack + "," + level;
    }
}
