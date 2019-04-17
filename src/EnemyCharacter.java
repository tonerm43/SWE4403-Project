import java.util.Random;

public class EnemyCharacter extends Character {
    private static EnemyCharacter instance;

    private int health;
    private int attack;
    private int level;
    private int experience;

    public static EnemyCharacter getInstance() {
        if (instance == null) {
            instance = new EnemyCharacter();
        }
        return instance;
    }

    private EnemyCharacter() {

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
}
