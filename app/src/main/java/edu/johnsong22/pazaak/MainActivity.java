package edu.johnsong22.pazaak;

/* @authors:
Glen Johnson, Jim Rowe, Grant Stone, James Conn
 */

import java.util.ArrayList;

import edu.johnsong22.pazaak.GameFramework.GameMainActivity;
import edu.johnsong22.pazaak.GameFramework.GamePlayer;
import edu.johnsong22.pazaak.GameFramework.LocalGame;
import edu.johnsong22.pazaak.GameFramework.gameConfiguration.GameConfig;
import edu.johnsong22.pazaak.GameFramework.gameConfiguration.GamePlayerType;

public class MainActivity extends GameMainActivity {
    private static final int PORT_NUMBER = 2278;

    @Override
    public GameConfig createDefaultConfig() {
        // Define the allowed player types
        ArrayList<GamePlayerType> playerTypes = new ArrayList<GamePlayerType>();

        // Pig has two player types:  human and computer
        playerTypes.add(new GamePlayerType("Local Human Player") {
            public GamePlayer createPlayer(String name) {
                return new PazaakHumanPlayer(name);
        }});
        playerTypes.add(new GamePlayerType("Computer Player") {
            public GamePlayer createPlayer(String name) {
                return new PazaakEasyAI(name);
        }});
        /* TODO: UNCOMMENT AFTER FINISHING AI FOR SMART PLAYER (POST ALPHA)
        playerTypes.add(new GamePlayerType("Smart Computer Player") {
            public GamePlayer createPlayer(String name) {
                return new PazaakHardAI(name);
        }});
        */

        // Create a game configuration class for Pig:
        GameConfig defaultConfig = new GameConfig(playerTypes, 1, 2, "Pig", PORT_NUMBER);
            defaultConfig.addPlayer("Human", 0); // player 1: a human player
            defaultConfig.addPlayer("Computer", 1); // player 2: a computer player
            defaultConfig.setRemoteData("Remote Human Player", "", 0);

        return defaultConfig;
    }

    /**
     * create a local game
     *
     * @return
     * 		the local game, a pig game
     */
    @Override
    public LocalGame createLocalGame() {
        return new PazaakLocalGame();
    }

}
