public class PlayerCharacterFactory extends AbstractCharacterFactory {

    public Character createCharacter(String name) {
        PlayerCharacter character= new PlayerCharacterBuilder()
                .createNewCharacter(name)
                .build();

        return character;
    }
}
