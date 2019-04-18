import javax.swing.*;
import java.awt.*;

public class GameSplashScreen extends GameWindow {
    private Container gridPane;
    private GameWindowFacade facade;

    public GameSplashScreen(GameWindowFacade facade) {
        this.facade = facade;
    }

    public void drawWindow() {
        this.setSize(400, 400);
        this.setTitle("DURGE");
        Container borderPane = new Container();
        gridPane = new Container();

        borderPane.setLayout(new BorderLayout());
        gridPane.setLayout(new GridLayout(2, 1));
        borderPane.add(gridPane, BorderLayout.CENTER);
        this.add(borderPane);
        ScrollingTextDecorator scrollingLabel = new ScrollingTextDecorator();
        gridPane.add(scrollingLabel);

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to DURGE ...");
        sb.append("\nFew survive the trials ahead");
        sb.append("\nMay the patterns have mercy\non your mortal soul . . .\n");
        scrollingLabel.setText(sb.toString());
        this.addButton();
    }

    private void addButton() {
        facade.beginButton = new JButton("BEGIN");
        facade.beginButton.setHorizontalAlignment(SwingConstants.CENTER);
        gridPane.add(facade.beginButton);
        this.revalidate();
        facade.beginButton.addActionListener(facade);
    }
}
