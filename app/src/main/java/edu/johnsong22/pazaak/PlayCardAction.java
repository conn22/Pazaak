package edu.johnsong22.pazaak;

import edu.johnsong22.pazaak.GameFramework.GamePlayer;
import edu.johnsong22.pazaak.GameFramework.actionMessage.GameAction;

public class PlayCardAction extends GameAction{

  private Cards card;

  public PlayCardAction(GamePlayer player, Cards toPlay){
    super(player);
    card = toPlay;
  }

  public Cards getCard() {
    return card;
  }
}
