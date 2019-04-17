/**
 * Abstract class to ensure common functionality
 * Characters are player and enemies
 */
public abstract class Character {
    public abstract int getHealth();
    public abstract void setHealth(int health);
    public abstract int getAttack();
    public abstract void setAttack(int attack);
    public abstract int getLevel();
    public abstract void setLevel(int level);
    public abstract int getExperience();
    public abstract void setExperience(int experience);
    public abstract int attack(Character other);
}
