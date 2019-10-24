package edu.johnsong22.pazaak;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class PlayView extends SurfaceView {

    private PazaakGameState pgs;

    private Paint text;

    private Bitmap background;
    private Bitmap cardNotPlayed;
    private Bitmap mainCards;
    private Bitmap addCards;
    private Bitmap minusCards;
    private Bitmap flipCardsPos;
    private Bitmap flipCardsNeg;
    private Bitmap specialCards;

    public PlayView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //NOTE: NEED TO HARD CODE AT THIS MOMENT
        int height = 1100;
        int width = 2000;

        int cardHeight = 150;
        int cardWidth = 210;

        text = new Paint();
        text.setStrokeWidth(5.0f);
        text.setColor(Color.WHITE);

        background = BitmapFactory.decodeResource(getResources(), R.drawable.game_background);
        background = Bitmap.createScaledBitmap(background, width, height, true);

        cardNotPlayed = BitmapFactory.decodeResource(getResources(), R.drawable.lbl_card_back);
        cardNotPlayed = Bitmap.createScaledBitmap(cardNotPlayed, cardWidth, cardHeight, true);

        mainCards = BitmapFactory.decodeResource(getResources(), R.drawable.lbl_card_stand);
        mainCards = Bitmap.createScaledBitmap(mainCards, cardWidth, cardHeight, true);

        addCards = BitmapFactory.decodeResource(getResources(), R.drawable.lbl_card_plus);
        addCards = Bitmap.createScaledBitmap(addCards, cardWidth, cardHeight, true);

        minusCards = BitmapFactory.decodeResource(getResources(), R.drawable.lbl_card_minus);
        minusCards = Bitmap.createScaledBitmap(minusCards, cardWidth, cardHeight, true);

        flipCardsPos = BitmapFactory.decodeResource(getResources(), R.drawable.lbl_card_flip_plus);
        flipCardsPos = Bitmap.createScaledBitmap(flipCardsPos, cardWidth, cardHeight, true);

        flipCardsNeg = BitmapFactory.decodeResource(getResources(), R.drawable.lbl_card_flip_minus);
        flipCardsNeg = Bitmap.createScaledBitmap(flipCardsNeg, cardWidth, cardHeight, true);

        specialCards = BitmapFactory.decodeResource(getResources(), R.drawable.lbl_card_special);
        specialCards = Bitmap.createScaledBitmap(specialCards, cardWidth, cardHeight, true);

        setWillNotDraw(false);
    }

    public void onDraw(Canvas canvas)  {
        canvas.drawBitmap(background, 0 , 0, null);
        drawCards(canvas);
        drawSideDeck(canvas);
    }

    public void drawCards(Canvas canvas) {
        int play0 = pgs.getPlayer0cardsUsed();
        int play1 = pgs.getPlayer0cardsUsed();

        Cards[] player0 = pgs.getPlayer0field();
        Cards[] player1 = pgs.getPlayer1field();
        SideDeck player0side;
        SideDeck player1side;

        int[] play0left = {300, 305, 720};
        int[] play1left = {1065, 1275, 1480};
        int[] top = {150, 325, 500};

        // TODO: add card values to draw.

        // Player 0
        int k = 0;
        for (int i = 0; i < 9; i++) {
            if (i == 3 || i == 6) {
                k++;
            }
            if (i < play0) {
                if (player0[i].getType() == 1) {
                    player0side = (SideDeck) player0[i];
                    if (player0side.isFlippable()) {
                        if (player0side.isNegitive()) {
                            canvas.drawBitmap(flipCardsNeg,play0left[i],top[k],null);
                        } else {
                            canvas.drawBitmap(flipCardsPos,play0left[i],top[k],null);
                        }
                    } else if (player0side.isNegitive()) {
                        canvas.drawBitmap(minusCards,play0left[i],top[k],null);
                    } else {
                        canvas.drawBitmap(addCards, play0left[i], top[k], null);
                    }
                } else {
                    canvas.drawBitmap(mainCards, play0left[i], top[k], null);
                }
            } else {
                canvas.drawBitmap(cardNotPlayed, play0left[i], top[k], null);
            }
        }

        // Player 1
        k = 0;
        for (int i = 0; i < 9; i++) {
            if (i == 3 || i == 6) {
                k++;
            }
            if (i < play1) {
                if (player0[i].getType() == 1) {
                    player1side = (SideDeck) player1[i];
                    if (player1side.isFlippable()) {
                        if (player1side.isNegitive()) {
                            canvas.drawBitmap(flipCardsNeg,play1left[i],top[k],null);
                        } else {
                            canvas.drawBitmap(flipCardsPos,play1left[i],top[k],null);
                        }
                    } else if (player1side.isNegitive()) {
                        canvas.drawBitmap(minusCards,play1left[i],top[k],null);
                    } else {
                        canvas.drawBitmap(addCards, play1left[i], top[k], null);
                    }
                } else {
                    canvas.drawBitmap(mainCards, play1left[i], top[k], null);
                }
            } else {
                canvas.drawBitmap(cardNotPlayed, play1left[i], top[k], null);
            }
        }
    }

    public void drawSideDeck(Canvas canvas) {
        int[] left = { 120, 325, 530, 740 };
        int top = 720;

        // TODO: add card values to draw

        SideDeck[] player0 = (SideDeck[]) pgs.getPlayer0side();
        for (int i = 0; i < 4; i++) {
            if (player0[i] == null) {
                canvas.drawBitmap(cardNotPlayed,left[i],top,null);
            } else if (player0[i].isFlippable()) {
                if (player0[i].isNegitive()) {
                    canvas.drawBitmap(flipCardsNeg,left[i],top,null);
                } else {
                    canvas.drawBitmap(flipCardsPos,left[i],top,null);
                }
            } else if (player0[i].isNegitive()) {
                canvas.drawBitmap(minusCards,left[i],top,null);
            } else {
                canvas.drawBitmap(addCards,left[i],top,null);
            }
        }

        //Other Players Side Decks
        Cards[] player1 = pgs.getPlayer1side();
        // Card 1
        if (player1[0] != null) {
            canvas.drawBitmap(mainCards, 1040, 720, null);
        } else {
            canvas.drawBitmap(cardNotPlayed, 1040, 720, null);
        }
        // Card 2
        if (player1[1] != null) {
            canvas.drawBitmap(mainCards, 1250, 720, null);
        } else {
            canvas.drawBitmap(cardNotPlayed, 1250, 720, null);
        }
        // Card 3
        if (player1[2] != null) {
            canvas.drawBitmap(mainCards, 1455, 720, null);
        } else {
            canvas.drawBitmap(cardNotPlayed, 1455, 720, null);
        }
        // Card 4
        if (player1[3] != null) {
            canvas.drawBitmap(mainCards, 1665, 720, null);
        } else {
            canvas.drawBitmap(mainCards, 1665, 720, null);
        }

    }

}
