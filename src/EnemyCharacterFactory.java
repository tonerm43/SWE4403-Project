public class EnemyCharacterFactory extends AbstractCharacterFactory{
    public Character createCharacter(String name) {
        EnemyCharacter enemy = new EnemyCharacter(DesignPattern.getRandomPattern().toString());
        enemy.characterFor(PlayerCharacter.getInstance().getLevel());
        return enemy;
    }
}
