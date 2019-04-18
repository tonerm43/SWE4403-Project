public class EnemyCharacter extends Character {
    private String name;
    private int health;
    private int attack;
    private int level;

    public EnemyCharacter(String name) {
        this.name = name;
    }

    @Override
    public void characterFor(int level) {
        this.level = level;
        this.health = 30 * 25*level;
        this.attack = 10 + 15*level;
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

    public EnemyCharacter clone() {
        EnemyCharacter clone = new EnemyCharacter(DesignPattern.getRandomPattern().toString());
        clone.characterFor(this.level);
        return clone;
    }
}
