import javax.swing.*;

public class ScrollingTextDecorator extends JLabel {
    private String HTML_PRE = "<html><body>";
    private String HTML_POST = "</html></body>";

    public ScrollingTextDecorator() {
        super();
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public ScrollingTextDecorator(String labelText) {
        super();
        this.scrollingText(labelText);
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public void setText(String labelText) {
        this.scrollingText(labelText);
    }

    /**
     * Creates a scrolling text effect on a JLabel
     * and supports multi-line labels
     * @param labelString The content of the label
     */
    private void scrollingText(String labelString) {
        StringBuilder sb = new StringBuilder();
        long delay;

        try {
            for (int i = 0; i < labelString.length(); i++) {
                switch (labelString.charAt(i)) {
                    case '\n':
                        delay = 0;
                        break;
                    case ' ':
                        delay = 100;
                        break;
                    case '.':
                        delay = 500;
                        break;
                    default:
                        delay = 300;
                }
                if (delay == 0) {
                    sb.append("<br>");
                } else {
                    sb.append(labelString.charAt(i));
                }
                super.setText(HTML_PRE + sb.toString() + HTML_POST);
                this.validate();
                Thread.sleep(delay);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
