public class PlayerCharacterBuilder {
    PlayerCharacter player;

    public PlayerCharacterBuilder() {
        player = PlayerCharacter.getInstance();
        player.reset();
    }


}
