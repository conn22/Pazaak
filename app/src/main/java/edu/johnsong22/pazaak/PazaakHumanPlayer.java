package edu.johnsong22.pazaak;

import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.widget.TextView;
import android.view.View.OnClickListener;

import edu.johnsong22.pazaak.GameFramework.GameHumanPlayer;
import edu.johnsong22.pazaak.GameFramework.GameMainActivity;
import edu.johnsong22.pazaak.GameFramework.infoMessage.GameInfo;

public class PazaakHumanPlayer extends GameHumanPlayer implements OnClickListener {

    ///TODO: CREATE GAME RESOURCES IT NEEDS FOR LISTENERS
    private Button endTurnButton = null;
    private Button standButton = null;
    private Button forfeitButton = null;

    private PlayView PlayView;
    private PazaakGameState pgs;

    private GameMainActivity myActivity;
    private int player;

    private TextView    player0total = null;
    private TextView    player1total    = null;

    private TextView    turnTotalTextView   = null;
    private TextView    messageTextView     = null;

    public PazaakHumanPlayer(String name) {
        super(name);
    }



    public View getTopView() {
        return myActivity.findViewById(R.id.PazaakView);
    }

    @Override
    public void receiveInfo(GameInfo info) {
        //TODO: SET PLAYER TO READ DATA

        if (info instanceof PazaakGameState) {

            //getTopView().invalidate();

            return;
        }
        flash(Color.RED, 10);
        return;
    }

    @Override
     public void onClick(View button) {

        if (button.getId() == R.id.hold) {
            game.sendAction(new StandAction(this));
        }
        if (button.getId() == R.id.endButton) {
            game.sendAction(new EndTurnAction(this));
        }
        if (button.getId() == R.id.forfeit) {
            //TODO: FILL IN
        }

    }

    public void setAsGui(GameMainActivity activity) {

        myActivity = activity;

        myActivity.setContentView(R.layout.activity_game);

        standButton = myActivity.findViewById(R.id.hold);
        endTurnButton = myActivity.findViewById(R.id.endButton);
        forfeitButton = myActivity.findViewById(R.id.forfeit);

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
        forfeitButton.setOnClickListener(this);

    }

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

}