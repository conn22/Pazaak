package edu.johnsong22.pazaak;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import edu.johnsong22.pazaak.GameFramework.GameHumanPlayer;
import edu.johnsong22.pazaak.GameFramework.GameMainActivity;
import edu.johnsong22.pazaak.GameFramework.infoMessage.GameInfo;

public class PazaakHumanPlayer extends GameHumanPlayer implements View.OnClickListener {

    ///TODO: CREATE GAME RESOURCES IT NEEDS FOR LISTENERS
    private Button holdButton = null;
    private Button standButton = null;

    private PlayView PlayView;
    private PazaakGameState pgs;

    private GameMainActivity myActivity;

    public PazaakHumanPlayer(String name) {
        super(name);
    }

    public View getTopView() {
        return myActivity.findViewById(R.id.top_gui_layout);
    }

    @Override
    public void receiveInfo(GameInfo info) {
        if (info instanceof PazaakGameState) {
                pgs = new PazaakGameState((PazaakGameState) info);
            return;
        }
        flash(Color.RED, 10);
        return;
    }

    //TODO: SET PLAYER BUTTON ACTIONS
    public void onClick(View button) {
        /*
        if (button.getId() == R.id.holdButton) {
            game.sendAction(new PigHoldAction(this));
        }
        if (button.getId() == R.id.dieButton) {
            game.sendAction(new PigRollAction(this));
        }
        */
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
        //standButton.setOnClickListener(this);
        //holdButton.setOnClickListener(this);

    }

}