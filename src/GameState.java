public class GameState {
    private State current;
    private PlayerState playerState;
    private EnemyState enemyState;

    public GameState() {
        playerState = new PlayerState();
        enemyState = new EnemyState();
        current = playerState;
    }

    public State getState() {
        return current;
    }

    public void setState(State state) {
        current = state;
    }

    public PlayerState getPlayerState() {
        return playerState;
    }

    public EnemyState getEnemyState() {
        return enemyState;
    }
}

abstract class State {
    public abstract void play(GameState wrapper);
}

class PlayerState extends State {
    public void play(GameState wrapper) {
        wrapper.setState(wrapper.getEnemyState());
    }
}

class EnemyState extends State {
    public void play(GameState wrapper) {
        wrapper.setState(wrapper.getPlayerState());
    }
}
