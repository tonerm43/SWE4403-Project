public class Client {

    public static void main(String[] args) {
        GameArbiter arbiter = GameArbiter.getInstance();
        arbiter.startGame();
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ": " + DesignPattern.getRandomPattern());
        }
    }
}
