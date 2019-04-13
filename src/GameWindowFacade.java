import javax.swing.*;
import java.awt.*;

public class GameWindowFacade extends JFrame {
    private ScrollingTextDecorator scrollingLabel;
    private Container borderPane, gridPane;

    public GameWindowFacade() {
        this.setSize(400, 400);
        this.setTitle("DURGE");
        borderPane = new Container();
        gridPane = new Container();

        borderPane.setLayout(new BorderLayout());
        gridPane.setLayout(new GridLayout(2, 1));
        borderPane.add(gridPane, BorderLayout.CENTER);
        this.add(borderPane);
        scrollingLabel = new ScrollingTextDecorator();
        gridPane.add(scrollingLabel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setScrollingText(String labelText) {
        this.scrollingLabel.setText(labelText);
    }

    public void addButton() {
        JButton beginButton = new JButton("BEGIN");
        beginButton.setHorizontalAlignment(SwingConstants.CENTER);
        gridPane.add(beginButton);
        this.validate();
    }
}
