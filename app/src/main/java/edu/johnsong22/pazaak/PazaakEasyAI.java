package edu.johnsong22.pazaak;

import edu.johnsong22.pazaak.GameFramework.GameComputerPlayer;
import edu.johnsong22.pazaak.GameFramework.infoMessage.GameInfo;

public class PazaakEasyAI extends GameComputerPlayer {

    public PazaakEasyAI(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        if (info instanceof PazaakGameState) {
            if (((PazaakGameState) info).getPlayer() != 0) {
                return;
            }
            sleep(1);
            int choose = (int) (Math.random()*3);
            switch (choose) {
                case 0:
                    game.sendAction(new EndTurnAction(this));
                    game.sendAction(new RoundWonAction(this));
                    game.sendAction(new StartTurnAction(this));
                    break;
                case 1:
                    game.sendAction(new PlayCardAction(this, new Card()));
                    break;
                case 2:
                    game.sendAction(new StandAction(this));
                    game.sendAction(new RoundWonAction(this));
                    game.sendAction(new StartTurnAction(this));
                    break;
                case 3:
                    break;
            }

            return;
        }
    }

}