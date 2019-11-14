package edu.johnsong22.pazaak;

import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.widget.TextView;

import edu.johnsong22.pazaak.GameFramework.GameHumanPlayer;
import edu.johnsong22.pazaak.GameFramework.GameMainActivity;
import edu.johnsong22.pazaak.GameFramework.infoMessage.GameInfo;

public class PazaakHumanPlayer extends GameHumanPlayer implements Button.OnClickListener, SurfaceView.OnTouchListener {

    ///TODO: CREATE GAME RESOURCES IT NEEDS FOR LISTENERS
    private Button endTurnButton = null;
    private Button standButton = null;
    private Button forfeitButton = null;

    private PlayView playView;
    private PazaakGameState pgs;

    private GameMainActivity myActivity;
    private int playerID = getPlayerID();

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
        if (info instanceof PazaakGameState) {

            pgs = new PazaakGameState((PazaakGameState)info);
            playView.getPGS(pgs);

            return;
        }
        flash(Color.RED, 10);
        return;
    }

    @Override
    public boolean onTouch(View v, MotionEvent me) {

        if ((me.getX() > 120 || me.getX() < 330) && (me.getY() > 720|| me.getY() < 870)) {
            game.sendAction(new PlayCardAction(this, pgs.getPlayer0side()[0]));
        } else if ((me.getX() > 325 || me.getX() < 535) && (me.getY() > 720|| me.getY() < 870)) {
            game.sendAction(new PlayCardAction(this, pgs.getPlayer0side()[1]));
        } else if ((me.getX() > 530 || me.getX() < 740) && (me.getY() > 720|| me.getY() < 870)) {
            game.sendAction(new PlayCardAction(this, pgs.getPlayer0side()[2]));
        } else if((me.getX() > 740 || me.getX() < 950) && (me.getY() > 720|| me.getY() < 870)) {
            game.sendAction(new PlayCardAction(this, pgs.getPlayer0side()[3]));
        }

        return false;
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
            game.sendAction(new PlayCardAction(this,  new Card()));
        }
        playView.invalidate();
    }

    public void setAsGui(GameMainActivity activity) {

        myActivity = activity;

        myActivity.setContentView(R.layout.activity_game);

        playView = myActivity.findViewById(R.id.PazaakView);

        standButton = myActivity.findViewById(R.id.hold);
        endTurnButton = myActivity.findViewById(R.id.endButton);
        forfeitButton = myActivity.findViewById(R.id.forfeit);

        //Listen for button presses
        standButton.setOnClickListener(this);
        endTurnButton.setOnClickListener(this);
        forfeitButton.setOnClickListener(this);
        playView.setOnTouchListener(this);

        pgs = new PazaakGameState();
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayer(int player) {
        this.playerID = player;
    }

}