public class PlayerCharacterFactory extends AbstractCharacterFactory {

    public Character createCharacter(String name) {
        return new PlayerCharacterBuilder()
                .createNewCharacter(name)
                .build();
    }
}
