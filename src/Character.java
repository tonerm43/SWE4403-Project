import java.util.Random;

/**
 * Abstract class to ensure common functionality
 * Characters are player and enemies
 */
public abstract class Character {
    private Random rand = new Random();

    public abstract void characterFor(int level);
    public abstract String getName();
    public abstract void setName(String name);
    public abstract int getHealth();
    public abstract void setHealth(int health);
    public abstract int getAttack();
    public abstract void setAttack(int attack);
    public abstract int getLevel();
    public abstract void setLevel(int level);

    public int attack(Character other, boolean defending) {
        int effectiveAttack = getAttack();
        effectiveAttack += (diceRoll()*5)*getLevel();
        if (defending) {
            effectiveAttack = effectiveAttack / 2;
        }

        if (effectiveAttack > other.getHealth()) {
            other.setHealth(0);
        } else {
            other.setHealth(other.getHealth() - effectiveAttack);
        }
        return effectiveAttack;
    }

    public int diceRoll() {
        return rand.nextInt(2 ) - 1;
    }
}
