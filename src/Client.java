public class Client {

    public static void main(String[] args) {
        GameWindowFacade gwf = new GameWindowFacade();
        gwf.startGame();
        for (int i = 0; i < 10; i++) {
            System.out.println(DesignPattern.getRandomPattern().toString());
        }
    }
}
