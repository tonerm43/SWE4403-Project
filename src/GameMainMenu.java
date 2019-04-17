import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.net.URL;

public class GameMainMenu extends GameWindow {
    private GameWindowFacade facade;

    public GameMainMenu(GameWindowFacade facade) {
        this.facade = facade;
    }

    public void drawWindow() {
        this.setSize(400, 400);
        this.setTitle("DURGE");

        Container borderPane = new Container();
        borderPane.setLayout(new BorderLayout());
        JLabel logo = new JLabel();
        logo.setIcon(loadImage());
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        borderPane.add(logo, BorderLayout.PAGE_START);

        Container gridPane = new Container();
        gridPane.setLayout(new GridLayout(3, 1));
        Container flowPane = new Container();
        flowPane.setLayout(new FlowLayout());
        facade.playerName = new JTextField(10);
        JLabel nameLabel = new JLabel("Player Name");
        flowPane.add(nameLabel);
        flowPane.add(facade.playerName);
        facade.newGame = new JButton("New Game");
        facade.newGame.addActionListener(facade);
        facade.newGame.setSize(new Dimension(100, 100));
        facade.loadGame = new JButton("Load Game");
        facade.loadGame.addActionListener(facade);
        facade.loadGame.setSize(new Dimension(100, 100));
        gridPane.add(flowPane);
        gridPane.add(facade.newGame);
        gridPane.add(facade.loadGame);
        borderPane.add(gridPane, BorderLayout.CENTER);

        this.add(borderPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private ImageIcon loadImage() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("durge_400.png");
        return new ImageIcon(resource);
    }
}
