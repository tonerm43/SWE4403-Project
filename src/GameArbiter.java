public class GameArbiter {
    private static GameArbiter instance;
    private static GameWindowFacade frame;

    public static GameArbiter getInstance() {
        if (instance == null) {
            instance = new GameArbiter();
        }
        return instance;
    }

    private GameArbiter() {

    }

    public void startGame() {
        frame = new GameWindowFacade();
        frame.startGame();
    }
}
