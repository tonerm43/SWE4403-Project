import java.io.*;
import java.util.Scanner;

public class PlayerMemento {

    /**
     * Checks if a player's save exists
     * @param name Player name to be used as a file name
     * @return If the player's save exists
     */
    public boolean playerExists(String name) {
        File file = new File(name + ".save");
        return file.exists();
    }

    /**
     * Saves a player's stats
     * @param name Player name to be used as a file name
     */
    public void savePlayer(String name) {
        PlayerCharacter player = PlayerCharacter.getInstance();
        File file = new File(name + ".save");
        try {
            file.createNewFile();
            FileWriter writer = new FileWriter(file);
            writer.write(player.toString());
            writer.close();
            System.out.println("File saved: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads in a player save if it exists
     * @param name The player's name. Used as a file name
     * @return The player's save file to be used by a builder
     */
    public String loadPlayer(String name) {
        String playerSave = null;
        if (playerExists(name)) {
            File file = new File(name + ".save");
            try {
                Scanner sc = new Scanner(file);
                playerSave = sc.nextLine();
                System.out.println(name + ".save: " + playerSave);
                sc.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Can not load save for " + name + ". File does not exist!");
        }
        return playerSave;
    }
}
