package edu.johnsong22.pazaak;

import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.View.OnClickListener;

import edu.johnsong22.pazaak.GameFramework.GameHumanPlayer;
import edu.johnsong22.pazaak.GameFramework.GameMainActivity;
import edu.johnsong22.pazaak.GameFramework.infoMessage.GameInfo;
import edu.johnsong22.pazaak.GameFramework.R;

public class PazaakHumanPlayer extends GameHumanPlayer implements OnClickListener {

    ///TODO: CREATE GAME RESOURCES IT NEEDS FOR LISTENERS
    private Button endTurnButton = null;
    private Button standButton = null;

    private GameMainActivity myActivity;


    //private TextView    player0wins = null;
    //private TextView    player1wins    = null;

    private TextView    player0total = null;
    private TextView    player1total    = null;

    private TextView    turnTotalTextView   = null;
    private TextView    messageTextView     = null;

    public PazaakHumanPlayer(String name) {
        super(name);
    }



    public View getTopView() {
        return myActivity.findViewById(R.id.top_gui_layout);
    }





    @Override
    public void receiveInfo(GameInfo info) {
        //TODO: SET PLAYER TO READ DATA

        if (info instanceof PazaakGameState) {

            if (((PazaakGameState) info).getPlayer0wins() == 1) {
                OneRoundWon.setColor(Color.RED);   //set color to red

            }
            if (((PazaakGameState) info).getPlayer0wins() == 2) {
                TwoRoundWon.setColor(Color.RED, 10);   //set color to red

            }
            if (((PazaakGameState) info).getPlayer0wins() == 3) {
                ThreeRoundWon.setImageResource(Color.RED);   //set color to red
            }
            player1total.setText("" + ((PazaakGameState) info).getPlayer0total());
            player0total.setText("" + ((PazaakGameState) info).getPlayer1total());


            return;
        }
        flash(Color.RED, 10);
        return;

    }

    //TODO: SET PLAYER BUTTON ACTIONS
     public void onClick(View button) {

        if (button.getId() == R.id.standButton) {
            game.sendAction(new StandAction(this));
        }
        if (button.getId() == R.id.endTurnButton) {
            game.sendAction(new EndTurnAction(this));
        }

    }

    public void setAsGui(GameMainActivity activity) {

        myActivity = activity;

        activity.setContentView(R.layout.activity_game);

        //TODO: SET GAME RESOURCES
        //this.playerScoreTextView = (TextView)activity.findViewById(R.id.yourScoreValue);
        //this.oppScoreTextView    = (TextView)activity.findViewById(R.id.oppScoreValue);
        //this.turnTotalTextView   = (TextView)activity.findViewById(R.id.turnTotalValue);
        //this.messageTextView     = (TextView)activity.findViewById(R.id.messageTextView);
        //this.dieImageButton      = (ImageButton)activity.findViewById(R.id.dieButton);
        //this.holdButton          = (Button)activity.findViewById(R.id.holdButton);

        //Listen for button presses
        standButton.setOnClickListener(this);
        endTurnButton.setOnClickListener(this);

    }

}