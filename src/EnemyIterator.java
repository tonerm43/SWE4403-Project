public class EnemyIterator {
    private EnemyCharacter current;

    public EnemyIterator(EnemyCharacter current) {
        this.current = current;
    }

    public boolean hasNext() {
        return current != null;
    }

    public EnemyCharacter next() {
        EnemyCharacter tmp = current;
        current = current.getNext();
        return tmp;
    }
}
