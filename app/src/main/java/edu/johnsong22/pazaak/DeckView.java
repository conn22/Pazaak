package edu.johnsong22.pazaak;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class DeckView extends SurfaceView {

    private Paint text;

    private Bitmap background;
    private Bitmap cardNotPlayed;
    private Bitmap mainCards;
    private Bitmap addCards;
    private Bitmap minusCards;
    private Bitmap flipCardsPos;
    private Bitmap flipCardsNeg;
    private Bitmap specialCards;

    public DeckView(Context context, AttributeSet attrs) {
        super(context, attrs);

        int height = 1000;
        int width = 1925;

        int cardHeight = 130;
        int cardWidth = 200;

        text = new Paint();
        text.setStrokeWidth(5.0f);
        text.setColor(Color.WHITE);

        background = BitmapFactory.decodeResource(getResources(), R.drawable.selection_background);
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
    }

    public void onDraw(Canvas canvas) {
        canvas.drawBitmap(background, 0 , 0, null);
        drawCards(canvas);
        drawSideDeck(canvas);
    }

    public void drawCards(Canvas canvas) {
        //SPECIAL ROW
        canvas.drawBitmap(specialCards, 150, 300, null);
        canvas.drawBitmap(specialCards, 330, 300, null);
        canvas.drawBitmap(specialCards, 520, 300, null);
        canvas.drawBitmap(specialCards, 715, 300, null);
        canvas.drawBitmap(specialCards, 910, 300, null);

        //PLUS ROW
        canvas.drawBitmap(addCards, 150, 445, null);
        canvas.drawBitmap(addCards, 330, 445, null);
        canvas.drawBitmap(addCards, 520, 445, null);
        canvas.drawBitmap(addCards, 715, 445, null);
        canvas.drawBitmap(addCards, 910, 445, null);
        canvas.drawBitmap(addCards, 1105, 445, null);

        //MINUS ROW
        canvas.drawBitmap(minusCards, 150, 585, null);
        canvas.drawBitmap(minusCards, 330, 585, null);
        canvas.drawBitmap(minusCards, 520, 585, null);
        canvas.drawBitmap(minusCards, 715, 585, null);
        canvas.drawBitmap(minusCards, 910, 585, null);
        canvas.drawBitmap(minusCards, 1105, 585, null);

        //FLIP ROW
        canvas.drawBitmap(flipCardsPos, 150, 725, null);
        canvas.drawBitmap(flipCardsPos, 330, 725, null);
        canvas.drawBitmap(flipCardsPos, 520, 725, null);
        canvas.drawBitmap(flipCardsPos, 715, 725, null);
        canvas.drawBitmap(flipCardsPos, 910, 725, null);
        canvas.drawBitmap(flipCardsPos, 1105, 725, null);

    }

    public void drawSideDeck(Canvas canvas) {
        //ODD CARDS
        canvas.drawBitmap(cardNotPlayed, 1390, 160, null);
        canvas.drawBitmap(cardNotPlayed, 1390, 300, null);
        canvas.drawBitmap(cardNotPlayed, 1390, 445, null);
        canvas.drawBitmap(cardNotPlayed, 1390, 585, null);
        canvas.drawBitmap(cardNotPlayed, 1390, 725, null);

        //EVEN CARDS
        canvas.drawBitmap(cardNotPlayed, 1580, 160, null);
        canvas.drawBitmap(cardNotPlayed, 1580, 300, null);
        canvas.drawBitmap(cardNotPlayed, 1580, 445, null);
        canvas.drawBitmap(cardNotPlayed, 1580, 585, null);
        canvas.drawBitmap(cardNotPlayed, 1580, 725, null);
    }
}
