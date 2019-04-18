import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController implements ActionListener {
    private GamePlayScreen frame;
    private GameState gameState;
    private EnemyCharacter enemyOne, enemyTwo;
    private boolean defending = false;
    private PlayerCharacter player;

    public GameController(GamePlayScreen frame) {
        this.frame = frame;
        this.gameState = new GameState();
        this.player = PlayerCharacter.getInstance();
    }

    public void playGame() {
        if (player.getLevel() <= 5) {
            generateEnemies();
        } else {
            frame.gameOver(true);
        }
    }

    public void levelUp() {
        gameState = new GameState();
        player.setLevel(player.getLevel() + 1);
        player.characterFor(player.getLevel());
        PlayerMemento memento = new PlayerMemento();
        memento.savePlayer(player.getName());
        frame.setStatusText("Level Up! Game saved");
        frame.updatePlayerStats();
        playGame();
    }

    public void attack() {
        int attack;
        String name;
        if (frame.enemyOneRadio.isSelected()) {
            attack = player.attack(enemyOne, false);
            name = enemyOne.getName();
        } else {
            attack = player.attack(enemyTwo, false);
            name = enemyTwo.getName();
        }
        frame.setStatusText("You attack " + name + " for " + attack + " damage!");
        frame.updateEnemyStats(enemyOne, enemyTwo);
        frame.validate();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (enemyOne.getHealth() == 0 && enemyTwo.getHealth() == 0) {
            levelUp();
        } else {
            gameState.getState().play(gameState);
            enemyTurn();
        }
    }

    public void defend() {
        this.defending = true;
        player.setHealth(player.getHealth() + 10*player.getLevel());
        gameState.getState().play(gameState);
        enemyTurn();
    }

    public void enemyTurn() {
        EnemyIterator iterator = enemyOne.getIterator();
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext() && player.getHealth() > 0) {
            EnemyCharacter tmp = iterator.next();
            if (tmp.getHealth() > 0) {
                int attack = tmp.attack(player, defending);
                sb.append(tmp.getName() + " attacks " + player.getName() + " for " + attack + " damage!");
                if (iterator.hasNext()) {
                    sb.append("<br>");
                }
            }
        }
        frame.setStatusText("<html><body>" + sb.toString() +"</body></html>");
        frame.updatePlayerStats();

        if (player.getHealth() > 0) {
            gameState.getState().play(gameState);
            this.defending = false;
        } else {
            frame.gameOver(false);
        }
    }

    public void generateEnemies() {
        AbstractCharacterFactory factory = AbstractCharacterFactory.getFactory(CharacterType.ENEMY);
        enemyOne = (EnemyCharacter) factory.createCharacter(DesignPattern.getRandomPattern().toString());
        enemyTwo = enemyOne.clone();
        frame.updateEnemyStats(enemyOne, enemyTwo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Only want to do anything if it is player's turn
        if (gameState.getState().equals(gameState.getPlayerState())) {
            if (e.getSource().equals(frame.attackButton)) {
                attack();
            } else if (e.getSource().equals(frame.defendButton)) {
                defend();
            }
        }
    }
}
