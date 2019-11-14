package edu.johnsong22.pazaak;

import edu.johnsong22.pazaak.GameFramework.GamePlayer;
import edu.johnsong22.pazaak.GameFramework.actionMessage.GameAction;
import edu.johnsong22.pazaak.GameFramework.LocalGame;
import edu.johnsong22.pazaak.GameFramework.infoMessage.GameState;

public class PazaakLocalGame extends LocalGame{
  
  PazaakGameState pGS;
  PlayView pv;
  
  public PazaakLocalGame(){
    pGS = new PazaakGameState();

  }
  
  protected boolean canMove(int playerID){
    return playerID == pGS.getPlayer();
  }

  @Override
  public boolean makeMove(GameAction action) {
    if (action instanceof PlayCardAction) {
      pGS.playCard(pGS.getPlayer(), ((PlayCardAction) action).getCard());
      return true;
    } else if (action instanceof EndTurnAction) {
      pGS.endTurn(pGS.getPlayer());
      pGS.roundWon();
      if (pGS.isJustWon()) {
        pGS.makeNewField();
      }
      pGS.onNewTurn();
      return true;
    } else if (action instanceof StandAction) {
      pGS.stand(pGS.getPlayer());
      pGS.roundWon();
      if (pGS.isJustWon()) {
        pGS.makeNewField();
      }
      pGS.onNewTurn();
      return true;
    } else if (action instanceof StartTurnAction) {
      pGS.onNewTurn();
      return true;
    } else if (action instanceof RoundWonAction) {
      pGS.roundWon();
      if (pGS.isJustWon()) {
        pGS.makeNewField();
      }
      return true;
    } else if(action instanceof NewFieldAction) {
      pGS.makeNewField();
      return true;
    } else if(action instanceof QuitAction){
      //exit game
      return true;
    } else
      return false;
  }

  @Override
  public void sendUpdatedStateTo(GamePlayer p){
      PazaakGameState pgsCpy = new PazaakGameState(pGS);
      p.sendInfo(pgsCpy);

  }

  @Override
  protected String checkIfGameOver(){
    if(pGS.getPlayer0wins() == 3)
      return ("Player 1 wins");
    else if(pGS.getPlayer1wins() == 3)
      return ("Player 2 wins");
    else
      return null;
  }
  
}
