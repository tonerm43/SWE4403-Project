import javax.swing.*;
import java.awt.event.WindowEvent;

public abstract class GameWindow extends JFrame {
    public abstract void drawWindow();
    public void destroy() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
}
