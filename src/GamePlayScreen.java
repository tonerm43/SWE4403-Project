import javax.swing.*;
import java.awt.*;

public class GamePlayScreen extends GameWindow {
    public Container playerStats, enemyStats, statusBar;
    public JLabel playerHealth, enemyOneHealth, enemyTwoHealth;
    public JLabel statusLabel;

    public void drawWindow() {
        PlayerCharacter player = PlayerCharacter.getInstance();
        this.setSize(400, 400);
        this.setTitle("DURGE");

        // Create UI Elements
        Container outerGridPane = new Container();
        outerGridPane.setLayout(new GridLayout(3, 1));
        Container characterGrid = new Container();
        characterGrid.setLayout(new GridLayout(1, 2));
        outerGridPane.add(characterGrid);
        playerStats = new Container();
        playerStats.setLayout(new BoxLayout(playerStats, BoxLayout.Y_AXIS));
        characterGrid.add(playerStats);
        playerStats.add(new JLabel(player.getName()));
        playerStats.add(new JLabel("Wonder If this works"));

        enemyStats = new Container();
        enemyStats.setLayout(new BoxLayout(enemyStats, BoxLayout.Y_AXIS));
        characterGrid.add(enemyStats);
        enemyStats.add(new JLabel("Pretend there's enemy stats here"));

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
        buttonsPane.add(new JButton("Attack"));
        buttonsPane.add(new JButton("Defend"));
        actionsPane.add(buttonsPane);

        Container radioPane = new Container();
        radioPane.setLayout(new GridLayout(2, 1));
        actionsPane.add(radioPane);
        JRadioButton enemyOne = new JRadioButton("Enemy 1", true);
        JRadioButton enemyTwo = new JRadioButton("Enemy 2");
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(enemyOne);
        radioGroup.add(enemyTwo);
        radioPane.add(enemyOne);
        radioPane.add(enemyTwo);

        this.add(outerGridPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
