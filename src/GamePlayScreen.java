import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class GamePlayScreen extends GameWindow {
    public Container outerGridPane, playerStats, enemyStats, statusBar;
    public JLabel playerName, playerHealth, enemyOneHealth, enemyTwoHealth, statusLabel;
    public JButton attackButton, defendButton;
    public ButtonGroup radioGroup;
    public JRadioButton enemyOneRadio, enemyTwoRadio;

    public void drawWindow() {
        GameController controller = new GameController(this);
        PlayerCharacter player = PlayerCharacter.getInstance();
        this.setSize(600, 400);
        this.setTitle("DURGE");

        // Create UI Elements
        outerGridPane = new Container();
        outerGridPane.setLayout(new GridLayout(3, 1));
        Container characterGrid = new Container();
        characterGrid.setLayout(new GridLayout(1, 2));
        outerGridPane.add(characterGrid);
        playerStats = new Container();
        playerStats.setLayout(new BoxLayout(playerStats, BoxLayout.Y_AXIS));
        characterGrid.add(playerStats);
        playerName = new JLabel(player.getName() + ": Level " + player.getLevel());
        playerHealth = new JLabel(player.getHealth() + " HP");
        playerStats.add(playerName);
        playerStats.add(playerHealth);

        enemyStats = new Container();
        enemyStats.setLayout(new BoxLayout(enemyStats, BoxLayout.Y_AXIS));
        characterGrid.add(enemyStats);
        enemyOneHealth = new JLabel();
        enemyTwoHealth = new JLabel();
        enemyStats.add(enemyOneHealth);
        enemyStats.add(enemyTwoHealth);

        statusBar = new Container();
        statusBar.setLayout(new FlowLayout());
        outerGridPane.add(statusBar);
        statusLabel = new JLabel();
        statusBar.add(statusLabel);

        Container actionsPane = new Container();
        actionsPane.setLayout(new GridLayout(1, 2));
        outerGridPane.add(actionsPane);
        Container buttonsPane = new Container();
        buttonsPane.setLayout(new GridLayout(2, 1));
        attackButton = new JButton("Attack");
        attackButton.addActionListener(controller);
        buttonsPane.add(attackButton);
        defendButton = new JButton("Defend");
        defendButton.addActionListener(controller);
        buttonsPane.add(defendButton);
        actionsPane.add(buttonsPane);

        Container radioPane = new Container();
        radioPane.setLayout(new GridLayout(2, 1));
        actionsPane.add(radioPane);
        enemyOneRadio = new JRadioButton("Enemy 1", true);
        enemyTwoRadio = new JRadioButton("Enemy 2");
        radioGroup = new ButtonGroup();
        radioGroup.add(enemyOneRadio);
        radioGroup.add(enemyTwoRadio);
        radioPane.add(enemyOneRadio);
        radioPane.add(enemyTwoRadio);

        this.add(outerGridPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        controller.playGame();
    }

    public void gameOver(boolean win) {
        this.remove(outerGridPane);
        String filename = win ? "win.png" : "lose.png";
        JLabel image = new JLabel();
        image.setIcon(loadImage(filename));
        image.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(image);
        this.pack();
        this.setLocationRelativeTo(null);
        this.validate();
    }

    public void updateEnemyStats(EnemyCharacter enemyOne, EnemyCharacter enemyTwo) {
        this.enemyOneHealth.setText(enemyOne.toString());
        this.enemyTwoHealth.setText(enemyTwo.toString());
        this.validate();
    }

    public void updatePlayerStats() {
        PlayerCharacter player = PlayerCharacter.getInstance();
        this.playerHealth.setText(player.getHealth() + " HP");
        this.validate();
    }

    public void setStatusText(String text) {
        statusLabel.setText(text);
        revalidate();
    }

    private ImageIcon loadImage(String name) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(name);
        return new ImageIcon(resource);
    }
}
