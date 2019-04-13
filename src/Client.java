public class Client {

    public static void main(String[] args) {
        GameWindowFacade frame = new GameWindowFacade();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        StringBuilder sb = new StringBuilder();
        sb.append("Welcome to DURGE ...");
        sb.append("\nFew survive the trials ahead");
        sb.append("\nMay the patterns have mercy\non your mortal soul\n");
        frame.setScrollingText(sb.toString());
        frame.addButton();
    }
}
