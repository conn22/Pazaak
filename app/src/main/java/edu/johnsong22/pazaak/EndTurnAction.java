package edu.johnsong22.pazaak;

import edu.johnsong22.pazaak.GameFramework.actionMessage.GameAction;

public class EndTurnAction extends GameAction {

    public boolean endTurn(int current_player) // maybe a helper funtion
    {
        if(getPlayer() == current_player) {
            setPlayer(getNextPlayer());
            return true;
        } else {
            return false;
        }
    }

}
