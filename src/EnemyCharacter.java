import java.util.Random;

public class EnemyCharacter extends Character {
    private static EnemyCharacter instance;

    private String name;
    private int health;
    private int attack;
    private int level;

    public static EnemyCharacter getInstance() {
        if (instance == null) {
            instance = new EnemyCharacter();
        }
        return instance;
    }

    private EnemyCharacter() {

    }

    @Override
    public void characterFor(int level) {
        this.level = level;
        this.health = 100 * 25*level;
        this.attack = 25 + 15*level;
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
    public int attack(Character other) {
        return 0;
    }
}
