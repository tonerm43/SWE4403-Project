import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindowFacade extends JFrame implements ActionListener {
    protected JButton beginButton, newGame, loadGame;
    protected JTextField playerName;
    private GameWindow windowStrategy;

    public void startGame() {
        windowStrategy = new GameSplashScreen(this);
        windowStrategy.drawWindow();
    }

    public void mainMenu() {
        windowStrategy = new GameMainMenu(this);
        windowStrategy.drawWindow();
    }

    public void newGame(String playerName) {
        AbstractCharacterFactory factory = AbstractCharacterFactory.getFactory(CharacterType.PLAYER);
        factory.createCharacter(playerName);
        windowStrategy = new GamePlayScreen();
        windowStrategy.drawWindow();
    }

    public void loadGame(String playerName) {
        PlayerCharacterBuilder builder = new PlayerCharacterBuilder();
        builder.loadCharacter(playerName);
        windowStrategy = new GamePlayScreen();
        windowStrategy.drawWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(beginButton)) {
            windowStrategy.destroy();
            mainMenu();
        } else if (e.getSource().equals(newGame)) {
            windowStrategy.destroy();
            newGame(playerName.getText());
        } else if (e.getSource().equals(loadGame)) {
            windowStrategy.destroy();
            loadGame(playerName.getText());
        }
    }
}
