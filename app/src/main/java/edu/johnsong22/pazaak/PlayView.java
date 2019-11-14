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
    private Paint turnIndacator;

    private Bitmap background;
    private Bitmap cardNotPlayed;
    private Bitmap mainCards;
    private Bitmap addCards;
    private Bitmap minusCards;
    private Bitmap flipCardsPos;
    private Bitmap flipCardsNeg;
    private Bitmap specialCards;

    private int height = 1100;
    private int width = 2000;
    private int cardHeight = 150;
    private int cardWidth = 210;

    public PlayView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //NOTE: NEED TO HARD CODE AT THIS MOMENT

        text = new Paint();
        text.setStrokeWidth(6.0f);
        text.setTextSize(32);
        text.setColor(Color.WHITE);

        turnIndacator = new Paint();
        turnIndacator.setStrokeWidth(6.0f);
        turnIndacator.setARGB(100, 0, 255, 70);

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
        drawTurnIndicator(canvas);

        if(pgs != null) {
            drawTotal(canvas);
            drawSideDeck(canvas);
            drawWins(canvas);
        }
        invalidate();
    }

    public void drawWins(Canvas canvas) {
        if (pgs.getPlayer0wins() >= 1) {
            canvas.drawCircle(175, 250, 15, turnIndacator);
            if (pgs.getPlayer0wins() >= 2) {
                canvas.drawCircle(175, 350, 15, turnIndacator);
                if (pgs.getPlayer0wins() == 3) {
                    canvas.drawCircle(175, 420, 15, turnIndacator);
                }
            }
        }

        if (pgs.getPlayer1wins() >= 1) {
            canvas.drawCircle(1820, 250, 15, turnIndacator);
            if (pgs.getPlayer1wins() >= 2) {
                canvas.drawCircle(1820, 350, 15, turnIndacator);
                if (pgs.getPlayer1wins() == 3) {
                    canvas.drawCircle(1820, 420, 15, turnIndacator);
                }
            }
        }
    }

    public void drawTurnIndicator(Canvas canvas) {
        if (pgs == null) {
            return;
        }
        if (pgs.getPlayer() == 0) {
            canvas.drawCircle(190, 105, 35, turnIndacator);
            return;
        }
        canvas.drawCircle(1800, 105, 35, turnIndacator);
    }

    public void drawTotal(Canvas canvas) {
        canvas.drawText(String.valueOf(pgs.getPlayer0total()), 905.0f, 102.5f, text);
        canvas.drawText(String.valueOf(pgs.getPlayer1total()), 1060.0f, 102.5f, text);
    }

    public void drawCards(Canvas canvas) {
        int play0 = 0;
        int play1 = 0;
        Card[] player0 = null;
        Card[] player1 = null;

        if (pgs != null) {
            play0 = pgs.getPlayer0cardsUsed();
            play1 = pgs.getPlayer1cardsUsed();

            player0 = pgs.getPlayer0field();
            player1 = pgs.getPlayer1field();
        }

        int[] play0left = {300, 505, 720};
        int[] play1left = {1065, 1275, 1480};
        int[] top = {150, 325, 500};

        // TODO: add card values to draw.

        // Player 0
        int k = 0;
        for (int i = 0; i < 9; i++) {
            if (i == 3 || i == 6) {
                k++;
            }

            if (i < play0 && play0 != 0) {
                if (player0[i] != null) {
                    if (player0[i].fromSideDeck()) {
                        if (player0[i].isFlippable()) {
                            if (player0[i].isNegitive()) {
                                canvas.drawBitmap(flipCardsNeg, play0left[i % 3], top[k], null);
                                canvas.drawText(String.valueOf(player0[i].value),
                                        play0left[i % 3] + (float) (cardWidth / 2) - 4.0f, top[k] + (cardHeight / 2) - 1.5f, text);
                            } else {
                                canvas.drawBitmap(flipCardsPos, play0left[i % 3], top[k], null);
                                canvas.drawText(String.valueOf(player0[i].value),
                                        play0left[i % 3] + (float) (cardWidth / 2) - 4.0f, top[k] + (cardHeight / 2) - 1.5f, text);
                            }
                        } else if (player0[i].isNegitive()) {
                            canvas.drawBitmap(minusCards, play0left[i % 3], top[k], null);
                            canvas.drawText(String.valueOf(player0[i].value),
                                    play0left[i % 3] + (float) (cardWidth / 2) - 4.0f, top[k] + (cardHeight / 2) - 1.5f, text);
                        } else {
                            canvas.drawBitmap(addCards, play0left[i % 3], top[k], null);
                            canvas.drawText(String.valueOf(player0[i].value),
                                    play0left[i % 3] + (float) (cardWidth / 2) - 4.0f, top[k] + (cardHeight / 2) - 1.5f, text);
                        }
                    } else {
                        canvas.drawBitmap(mainCards, play0left[i % 3], top[k], null);
                        canvas.drawText(String.valueOf(player0[i].value),
                                play0left[i % 3] + (float) (cardWidth / 2) - 4.0f, top[k] + (cardHeight / 2) - 1.5f, text);
                    }
                } else {
                    canvas.drawBitmap(cardNotPlayed, play0left[i % 3], top[k], null);
                }
            } else {
                canvas.drawBitmap(cardNotPlayed, play0left[i % 3], top[k], null);
            }
        }

        // Player 1
        k = 0;
        for (int i = 0; i < 9; i++) {
            if (i == 3 || i == 6) {
                k++;
            }
            if (i < play1 && play1 != 0) {
                if (player1[i] != null) {
                    if (player1[i].fromSideDeck()) {
                        if (player1[i].isFlippable()) {
                            if (player1[i].isNegitive()) {
                                canvas.drawBitmap(flipCardsNeg, play1left[i % 3], top[k], null);
                                canvas.drawText(String.valueOf(player1[i].value),
                                        play1left[i % 3] + (float) (cardWidth / 2) - 4.0f, top[k] + (cardHeight / 2) - 1.5f, text);
                            } else {
                                canvas.drawBitmap(flipCardsPos, play1left[i % 3], top[k], null);
                                canvas.drawText(String.valueOf(player1[i].value),
                                        play1left[i % 3] + (float) (cardWidth / 2) - 4.0f, top[k] + (cardHeight / 2) - 1.5f, text);
                            }
                        } else if (player1[i].isNegitive()) {
                            canvas.drawBitmap(minusCards, play1left[i % 3], top[k], null);
                            canvas.drawText(String.valueOf(player1[i].value),
                                    play1left[i % 3] + (float) (cardWidth / 2) - 4.0f, top[k] + (cardHeight / 2) - 1.5f, text);
                        } else {
                            canvas.drawBitmap(addCards, play1left[i % 3], top[k], null);
                            canvas.drawText(String.valueOf(player1[i].value),
                                    play1left[i % 3] + (float) (cardWidth / 2) - 4.0f, top[k] + (cardHeight / 2) - 1.5f, text);
                        }
                    } else {
                        canvas.drawBitmap(mainCards, play1left[i % 3], top[k], null);
                        canvas.drawText(String.valueOf(player1[i].value),
                                play1left[i % 3] + (float) (cardWidth / 2) - 4.0f, top[k] + (cardHeight / 2) - 1.5f, text);
                    }
                } else {
                    canvas.drawBitmap(cardNotPlayed, play1left[i % 3], top[k], null);
                }
            } else {
                canvas.drawBitmap(cardNotPlayed, play1left[i % 3], top[k], null);
            }
        }
    }

    public void drawSideDeck(Canvas canvas) {
        int[] left = { 120, 325, 530, 740 };
        int top = 720;

        // TODO: add card values to draw


        Card[] player0 = pgs.getPlayer0side();
        for (int i = 0; i < 4; i++) {
            if (player0[i] == null) {
                canvas.drawBitmap(cardNotPlayed,left[i],top,null);
            } else if (player0[i].isFlippable()) {
                if (player0[i].isNegitive()) {
                    canvas.drawBitmap(flipCardsNeg,left[i],top,null);
                    canvas.drawText(String.valueOf(player0[i].value),
                            left[i] + (float)(cardWidth/2) - 4.0f, top + (cardHeight/2) - 1.5f, text);
                } else {
                    canvas.drawBitmap(flipCardsPos,left[i],top,null);
                    canvas.drawText(String.valueOf(player0[i].value),
                            left[i] + (float)(cardWidth/2) - 4.0f, top + (cardHeight/2) - 1.5f, text);
                }
            } else if (player0[i].isNegitive()) {
                canvas.drawBitmap(minusCards,left[i],top,null);
                canvas.drawText(String.valueOf(player0[i].value),
                        left[i] + (float)(cardWidth/2) - 4.0f, top + (cardHeight/2) - 1.5f, text);
            } else {
                canvas.drawBitmap(addCards,left[i],top,null);
                canvas.drawText(String.valueOf(player0[i].value),
                        left[i] + (float)(cardWidth/2) - 4.0f, top + (cardHeight/2) - 1.5f, text);
            }
        }

        //Other Players Side Decks
        Card[] player1 = pgs.getPlayer1side();
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

    public void getPGS(PazaakGameState p) {
        pgs = p;
    }

}
