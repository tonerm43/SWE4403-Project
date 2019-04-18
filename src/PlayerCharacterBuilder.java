public class PlayerCharacterBuilder {
    PlayerCharacter player;

    public PlayerCharacterBuilder() {
        player = PlayerCharacter.getInstance();
        player.reset();
    }

    public PlayerCharacterBuilder loadCharacter(String name) {
        PlayerMemento memento = new PlayerMemento();
        String character = memento.loadPlayer(name);
        String[] attributes = character.split(",");
        player.setName(attributes[0]);
        player.setHealth(Integer.parseInt(attributes[1]));
        player.setAttack(Integer.parseInt(attributes[2]));
        player.setLevel(Integer.parseInt(attributes[3]));
        return this;
    }

    public PlayerCharacterBuilder createNewCharacter(String name) {
        player.setName(name);
        player.characterFor(1);
        return this;
    }

    public PlayerCharacter build() {
        return player;
    }
}
