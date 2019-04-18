import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {
    private GamePlayScreen frame;
    private GameState gameState;

    public GameController(GamePlayScreen frame) {
        this.frame = frame;
        this.gameState = new GameState();
    }

    public void playGame() {

    }

    public void generateEnemies() {
        AbstractCharacterFactory factory = AbstractCharacterFactory.getFactory(CharacterType.ENEMY);
        factory.createCharacter(DesignPattern.getRandomPattern().toString());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Only want to do anything if it is player's turn
        if (gameState.getState().equals(gameState.getPlayerState())) {
            if (e.getSource().equals(frame.attackButton)) {
                System.out.println("attack, " + frame.radioGroup.getSelection().getMnemonic());
            } else if (e.getSource().equals(frame.defendButton)) {
                System.out.println("defend, " + frame.radioGroup.getSelection());
            }
        }
    }
}
