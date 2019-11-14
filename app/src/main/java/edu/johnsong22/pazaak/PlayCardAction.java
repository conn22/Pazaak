package edu.johnsong22.pazaak;

import edu.johnsong22.pazaak.GameFramework.GamePlayer;
import edu.johnsong22.pazaak.GameFramework.actionMessage.GameAction;

public class PlayCardAction extends GameAction{

  private Card card;

  public PlayCardAction(GamePlayer player, Card toPlay){
    super(player);
    card = toPlay;
  }

  public Card getCard() {
    return card;
  }
}
