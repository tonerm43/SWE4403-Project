public class PlayerCharacter extends Character {
    private static PlayerCharacter instance;

    private int health;
    private int attack;
    private int level;
    private int experience;

    public static PlayerCharacter getInstance() {
        if (instance == null) {
            instance = new PlayerCharacter();
        }
        return instance;
    }

    private PlayerCharacter() {

    }

    public void reset() {
        health = 0;
        attack = 0;
        level = 0;
        experience = 0;
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
    public int getExperience() {
        return experience;
    }

    @Override
    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public int attack(Character other) {
        return 0;
    }

    @Override
    public String toString() {
        return health + "," + attack + "," + level + "," + experience;
    }
}
