package edu.johnsong22.pazaak;

/* @authors:
Glen Johnson, Jim Rowe, Grant Stone, James Conn
 */

import edu.johnsong22.pazaak.GameFramework.infoMessage.GameState;

public class PazaakGameState extends GameState {

    private int player;
    private boolean justWon;

    private int player0total;
    private int player1total;

    private int player0wins;
    private int player1wins;

    private boolean isPlayer0standing;
    private boolean isPlayer1standing;

    private int player0cardsDrawn;
    private int player1cardsDrawn;

    private int player0cardsUsed;
    private int player1cardsUsed;

    private Card[] player0field;
    private Card[] player1field;

    private Card[] player0side;
    private Card[] player1side;

    public PazaakGameState() {
        player0wins = 0;
        player1wins = 0;

        isPlayer0standing = false;
        isPlayer1standing = false;

        justWon = false;

        player0cardsDrawn = 0;
        player1cardsDrawn = 0;

        player0cardsUsed = 0;
        player1cardsUsed = 0;

        player = (int) (Math.random());

        player0total = 0;
        player0field = new Card[9];
        player0side = new Card[4];

        player1total = 0;
        player1field = new Card[9];
        player1side = new Card[4];

        for (int i = 0; i < 4; i++) {
            player0side[i] = new Card(true);
            player1side[i] = new Card(true);
        }

        //startTurn(player);
    }

    public PazaakGameState(PazaakGameState pgs) {
        player0wins = pgs.getPlayer0wins();
        player1wins = pgs.getPlayer1wins();

        justWon = pgs.justWon;

        isPlayer0standing = pgs.getIsPlayer0Standing();
        isPlayer1standing = pgs.getIsPlayer1Standing();

        player0cardsDrawn = pgs.getPlayer0cardsDrawn();
        player1cardsDrawn = pgs.getPlayer1cardsDrawn();

        player0cardsUsed = pgs.getPlayer0cardsUsed();
        player1cardsUsed = pgs.getPlayer1cardsUsed();

        this.player = pgs.getNextPlayer();
        this.player0wins = pgs.getPlayer0wins();
        this.player1wins = pgs.getPlayer1wins();

        this.player0total = pgs.getPlayer0total();
        this.player1total = pgs.getPlayer1total();

        Card[] oldField = pgs.getPlayer0field();
        this.player0field = new Card[9];
        for (int i = 0; i < 9; i++) {
            if (oldField[i] == null) {
                break;
            }
            player0field[i] = new Card(oldField[i]);
        }

        oldField = pgs.getPlayer0side();
        this.player0side = new Card[4];
        for (int i = 0; i < 4; i++) {
            if (oldField[i] == null) {
            } else {
                player0side[i] = new Card(oldField[i]);
            }
        }

        oldField = pgs.getPlayer1field();
        this.player1field = new Card[9];
        for (int i = 0; i < 9; i++) {
            if (oldField[i] == null) {
                break;
            }
            player1field[i] = new Card(oldField[i]);
        }

        oldField = pgs.getPlayer1side();
        this.player1side = new Card[4];
        for (int i = 0; i < 4; i++) {
            if (oldField[i] == null) {
            } else {
                player1side[i] = new Card(oldField[i]);
            }
        }
    }

    public boolean isJustWon() {
        return justWon;
    }

    public int getPlayer() {
        return player;
    }

    public int getNextPlayer() {
        if (player == 1) {
            return 0;
        }
        if (player == 0) {
            return 1;
        }
        return player;
    }

    public int getPlayer0wins() {
        return player0wins;
    }

    public int getPlayer0total() {
        return player0total;
    }

    public int getPlayer0cardsDrawn() {
        return player0cardsDrawn;
    }

    public int getPlayer0cardsUsed() {
        return player0cardsUsed;
    }

    public Card[] getPlayer0field() {
        return player0field;
    }

    public Card[] getPlayer0side() {
        return player0side;
    }

    public int getPlayer1wins() {
        return player1wins;
    }

    public int getPlayer1total() {
        return player1total;
    }

    public Card[] getPlayer1field() {
        return player1field;
    }

    public Card[] getPlayer1side() {
        return player1side;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public void addPlayer0cardsDrawn() {
        this.player0cardsDrawn += 1;
    }

    public void addPlayer1cardsDrawn() {
        player1cardsDrawn += 1;
    }

    public void addPlayer0cardsUsed() {
        this.player0cardsUsed += 1;
    }

    public void addPlayer1cardsUsed() {
        this.player1cardsUsed += 1;
    }

    public int getPlayer1cardsDrawn() {
        return player1cardsDrawn;
    }

    public boolean getIsPlayer0Standing() {
        return isPlayer0standing;
    }

    public boolean getIsPlayer1Standing() {
        return isPlayer1standing;
    }

    public int getPlayer1cardsUsed() {
        return player1cardsUsed;
    }

    public void updateTotals() {
        player0total = 0;
        player1total = 0;
        if (player0cardsDrawn != 0) {
            for (int i = 0; i < player0cardsDrawn; i++) {
                player0total += player0field[i].value;
            }
        }
        if (player1cardsDrawn != 0) {
            for (int i = 0; i < player1cardsDrawn; i++) {
                player1total += player1field[i].value;
            }
        }
    }

    public void onNewTurn() {
        if(player == 0 && !isPlayer0standing) {
            player0field[player0cardsDrawn] = new Card();
            player0cardsDrawn++;
        } else if(player == 1 && !isPlayer1standing) {
            player1field[player1cardsDrawn] = new Card();
            player1cardsDrawn++;
        }
        updateTotals();
    }

    // need to see inside every array and parameter

    //  0,   which card to play , any player, player plays a card and tells wich card is played, updating more then just the the return
    public  boolean playCard(int current_player, Card somecard) {
        if (somecard == null) { return false; }
        if (!canPlay(current_player)) { return false; }
        if (getPlayer() == current_player) {  // if it is the human players turn,
            if (current_player == 0) {
                player0field[player0cardsDrawn] = somecard;
                addPlayer0cardsUsed();
                addPlayer0cardsDrawn();
                for (int i = 0; i < 4; i++) {
                    if (somecard == player0side[i]) {
                        player0side[i] = null;
                    }
                }
            } else {
                player1field[player1cardsDrawn] = somecard;
                addPlayer1cardsUsed();
                addPlayer1cardsDrawn();
            }
            updateTotals();
            return true;
        } else {
            return false;
        }
    }

    public boolean stand(int current_player)
    {
        if (!canPlay(current_player)) { return false; }
        if(getPlayer() == current_player) {  // if it is the human players turn,
            if (current_player == 0) {
                setPlayer(getNextPlayer());
                isPlayer0standing = true;
            } else {
                setPlayer(getNextPlayer());
                isPlayer1standing = true;
            }
            return true;
        }
        else
            return false;
    }

    public boolean endTurn(int current_player) {
        if (current_player == player) {
            setPlayer(getNextPlayer());
            return true;
        }
        return false;
    }

    public boolean roundWon() {
        if (player0total > 20){
            player1wins++;
            justWon = true;
            return false;
        }else if(player1total > 20){
            player0wins++;
            justWon = true;
            return true;
        }else if(isPlayer0standing && isPlayer1standing){
            if(player0total > player1total){
                player0total++;
                justWon = true;
                return true;
            }else if(player1total > player0total) {
                player1total++;
                justWon = true;
                return true;
            } else {
                justWon = true;
                return true;
            }
        }
        return false;
    }

    public void makeNewField() {
        for(int i = 0; i < 9; i++){
            player0field[i] = null;
            player1field[i] = null;
        }
        justWon = false;
        player0cardsDrawn = 0;
        player1cardsDrawn = 0;
        isPlayer0standing = false;
        isPlayer1standing = false;
    }

    public boolean canPlay(int current_player) {
        if(current_player == 0) {
            if (!isPlayer0standing || player0total < 20) {
                return true;
            }
            return false;
        }
        if(current_player == 1) {
            if (!isPlayer1standing || player1total < 20) {
                return true;
            }
            return false;
        }
        return false;
    }

}

