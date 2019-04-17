import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class GameWindowFacade extends JFrame implements ActionListener {
    private ScrollingTextDecorator scrollingLabel;
    private Container borderPane, gridPane;
    private JButton beginButton, newGame, loadGame;

    public void addButton() {
        beginButton = new JButton("BEGIN");
        beginButton.setHorizontalAlignment(SwingConstants.CENTER);
        gridPane.add(beginButton);
        this.revalidate();
        beginButton.addActionListener(this);
    }

    public void splashScreen() {
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

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to DURGE ...");
        sb.append("\nFew survive the trials ahead");
        sb.append("\nMay the patterns have mercy\non your mortal soul\n");
        this.scrollingLabel.setText(sb.toString());
        this.addButton();
    }

    public void mainMenu() {
        borderPane.removeAll();
        this.getContentPane().setBackground(Color.BLACK);
        JLabel logo = new JLabel();
        logo.setIcon(loadImage());
        logo.setHorizontalAlignment(SwingConstants.CENTER);
        borderPane.add(logo, BorderLayout.PAGE_START);

        gridPane.removeAll();
        newGame = new JButton("New Game");
        newGame.addActionListener(this);
        newGame.setSize(new Dimension(100, 100));
        loadGame = new JButton("Load Game");
        loadGame.addActionListener(this);
        loadGame.setSize(new Dimension(100, 100));
        gridPane.add(newGame);
        gridPane.add(loadGame);
        borderPane.add(gridPane, BorderLayout.CENTER);

        this.add(borderPane);
        this.revalidate();
        this.repaint();
    }

    public ImageIcon loadImage() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("durge_400.png");
        return new ImageIcon(resource);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(beginButton)) {
            mainMenu();
        } else if (e.getSource().equals(newGame)) {
            System.out.println("new");
        } else if (e.getSource().equals(loadGame)) {
            System.out.println("load");
        }
    }
}
