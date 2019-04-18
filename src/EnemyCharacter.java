public class EnemyCharacter extends Character {
    private String name;
    private int health;
    private int attack;
    private int level;
    private EnemyCharacter next;

    public EnemyCharacter(String name) {
        this.name = name;
    }

    @Override
    public void characterFor(int level) {
        this.level = level;
        this.health = 30 + 25*(level - 1);
        this.attack = 10 + 15*(level - 1);
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

    public EnemyCharacter clone() {
        EnemyCharacter clone = new EnemyCharacter(DesignPattern.getRandomPattern().toString());
        clone.characterFor(this.level);
        clone.next = null;
        this.next = clone;
        return clone;
    }

    public String toString() {
        return "Level " + this.level + " " + this.name + ": " + this.health + " HP";
    }

    public EnemyIterator getIterator() {
        return new EnemyIterator(this);
    }

    public EnemyCharacter getNext() {
        return this.next;
    }
}
