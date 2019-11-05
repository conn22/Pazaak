package edu.johnsong22.pazaak;

import edu.johnsong22.pazaak.GameFramework.GameComputerPlayer;
import edu.johnsong22.pazaak.GameFramework.infoMessage.GameInfo;

public class PazaakEasyAI extends GameComputerPlayer {

    public PazaakEasyAI(String name) {
        super(name);
    }

    @Override
    protected void receiveInfo(GameInfo info) {
        //TODO: SET PLAYER TO READ DATA
        /*
        if (info instanceof PazaakGameState) {



            return;
        }

         */
    }

}