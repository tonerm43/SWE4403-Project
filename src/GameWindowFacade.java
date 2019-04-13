import javax.swing.*;
import java.awt.*;

public class GameWindowFacade extends JFrame {
    private ScrollingTextDecorator scrollingLabel;
    private Container borderPane;

    public GameWindowFacade() {
        this.setSize(400, 400);
        this.setTitle("DURGE");
        borderPane = new Container();

        borderPane.setLayout(new BorderLayout());
        scrollingLabel = new ScrollingTextDecorator();
        borderPane.add(scrollingLabel, BorderLayout.CENTER);
        this.add(borderPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setScrollingText(String labelText) {
        this.scrollingLabel.setText(labelText);
    }

    public void addButton() {
        borderPane.add(new JButton("BEGIN"), BorderLayout.PAGE_END);
        this.validate();
    }
}
