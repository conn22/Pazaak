package edu.johnsong22.pazaak;

import edu.johnsong22.pazaak.GameFramework.GamePlayer;
import edu.johnsong22.pazaak.GameFramework.actionMessage.GameAction;
import edu.johnsong22.pazaak.GameFramework.LocalGame;
import edu.johnsong22.pazaak.GameFramework.infoMessage.GameState;

public class PazaakLocalGame extends LocalGame{
  
  PazaakGameState pGS;
  
  public PazaakLocalGame(){
    pGS = new PazaakGameState();
  }
  
  protected boolean canMove(int playerID){
    return playerID == pGS.getPlayer();
  }
  
  public boolean makeMove(GameAction action){
    if(action instanceof PlayCardAction){
      
      return true;
    }else if(action instanceof EndTurnAction){
      
      return true;
    }else if(action instanceof StandAction){
      
      return true;
    }else if(action instanceof QuitAction){
      
      return true;
    }else
      return false;
  }
  
  public void sendUpdatedStateTo(GamePlayer p){
      PazaakGameState pgsCpy = new PazaakGameState(pGS);
      p.sendInfo(pgsCpy);
  }
  
  protected String checkIfGameOver(){
    if(pGS.getPlayer0wins() == 3)
      return ("Player 1 wins");
    else if(pGS.getPlayer1wins() == 3)
      return ("Player 2 wins");
    else
      return null;
  }
  
}
