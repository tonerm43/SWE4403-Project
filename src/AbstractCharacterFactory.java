public abstract class AbstractCharacterFactory {

    /** Returns a concrete factory object that is an instance of the
     * concrete factory class appropriate for the given character type.
     * @param characterType CharacterType enum to get factory for
     */
    static AbstractCharacterFactory getFactory(CharacterType characterType) {
        AbstractCharacterFactory factory = null;
        switch (characterType) {
            case PLAYER:
                factory = new PlayerCharacterFactory();
                break;
            case ENEMY:
                factory = new EnemyCharacterFactory();
                break;
        }
        return factory;
    }

    public abstract Character createCharacter(String name);
}
