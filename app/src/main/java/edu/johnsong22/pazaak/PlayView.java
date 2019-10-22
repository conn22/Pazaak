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
        canvas.drawBitmap(cardNotPlayed, 300, 150, null);
        canvas.drawBitmap(cardNotPlayed, 505, 150, null);
        canvas.drawBitmap(cardNotPlayed, 720, 150, null);
        canvas.drawBitmap(cardNotPlayed, 1065, 150, null);
        canvas.drawBitmap(cardNotPlayed, 1275, 150, null);
        canvas.drawBitmap(cardNotPlayed, 1480, 150, null);

        canvas.drawBitmap(cardNotPlayed, 300, 325, null);
        canvas.drawBitmap(cardNotPlayed, 505, 325, null);
        canvas.drawBitmap(cardNotPlayed, 720, 325, null);
        canvas.drawBitmap(cardNotPlayed, 1065, 325, null);
        canvas.drawBitmap(cardNotPlayed, 1275, 325, null);
        canvas.drawBitmap(cardNotPlayed, 1480, 325, null);

        canvas.drawBitmap(cardNotPlayed, 300, 500, null);
        canvas.drawBitmap(cardNotPlayed, 505, 500, null);
        canvas.drawBitmap(cardNotPlayed, 720, 500, null);
        canvas.drawBitmap(cardNotPlayed, 1065, 500, null);
        canvas.drawBitmap(cardNotPlayed, 1275, 500, null);
        canvas.drawBitmap(cardNotPlayed, 1480, 500, null);
    }

    public void drawSideDeck(Canvas canvas) {
        canvas.drawBitmap(mainCards, 120, 720, null);
        canvas.drawBitmap(mainCards, 325, 720, null);
        canvas.drawBitmap(mainCards, 530, 720, null);
        canvas.drawBitmap(mainCards, 740, 720, null);

        canvas.drawBitmap(mainCards, 1040, 720, null);
        canvas.drawBitmap(mainCards, 1250, 720, null);
        canvas.drawBitmap(mainCards, 1455, 720, null);
        canvas.drawBitmap(mainCards, 1665, 720, null);
    }

}
