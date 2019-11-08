package edu.johnsong22.pazaak;

import edu.johnsong22.pazaak.GameFramework.GamePlayer;
import edu.johnsong22.pazaak.GameFramework.actionMessage.GameAction;

public class EndTurnAction extends GameAction {
    
    public EndTurnAction(GamePlayer player){
      super(player);  
    }

}
