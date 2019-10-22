package edu.johnsong22.pazaak;

/* @authors:
Glen Johnson, Jim Rowe, Grant Stone, James Conn
 */

public class PazaakGameState {

    private int player;

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

    private Cards[] player0field;
    private Cards[] player1field;

    private Cards[] player0side;
    private Cards[] player1side;

    public PazaakGameState() {
        player0wins = 0;
        player1wins = 0;

        isPlayer0standing = false;
        isPlayer1standing = false;

        player0cardsDrawn = 0;
        player1cardsDrawn = 0;

        player0cardsUsed = 0;
        player1cardsUsed = 0;

        player = (int) (Math.random()*2);

        player0total = 0;
        player0field = new Cards[9];
        player0side = new Cards[4];

        player1total = 0;
        player1field = new Cards[9];
        player1side = new Cards[4];

        for (int i = 0; i < 4; i++) {
            player0side[i] = new SideDeck();
            player1side[i] = new SideDeck();
        }
    }

    public PazaakGameState(PazaakGameState pgs) {
        player0wins = pgs.getPlayer0wins();
        player1wins = pgs.getPlayer1wins();

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

        Cards[] oldField = pgs.getPlayer0field();
        this.player0field = new Cards[9];
        for (int i = 0; i < 9; i++) {
            player0field[i] = oldField[i];
        }

        oldField = pgs.getPlayer0side();
        this.player0side = new Cards[4];
        for (int i = 0; i < 4; i++) {
            player0side[i] = oldField[i];
        }

        oldField = pgs.getPlayer1field();
        this.player1field = new Cards[9];
        for (int i = 0; i < 9; i++) {
            player1field[i] = oldField[i];
        }

        oldField = pgs.getPlayer1side();
        this.player1side = new Cards[4];
        for (int i = 0; i < 4; i++) {
            player1side[i] = oldField[i];
        }
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

    public Cards[] getPlayer0field() {
        return player0field;
    }

    public Cards[] getPlayer0side() {
        return player0side;
    }

    public int getPlayer1wins() {
        return player1wins;
    }

    public int getPlayer1total() {
        return player1total;
    }

    public Cards[] getPlayer1field() {
        return player1field;
    }

    public Cards[] getPlayer1side() {
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
        if(player == 0) {
            player0field[player0cardsDrawn] = new MainDeck();
            player0cardsDrawn++;
        }
        if(player == 1) {
            player1field[player0cardsDrawn] = new MainDeck();
            player1cardsDrawn++;
        }
        updateTotals();
    }

    @Override
    public String toString() {
        String stateInfo = "\nWho's Turn: " + player + "\nPlayer 0 Rounds won: " + player0wins +
                "\nPlayer 1 Rounds won: " + player1wins + "\nPlayer 0 total: " + player0total +
                "\nPlayer 1 total: " + player1total + "\nPlayer 0 cards: ";
        for (int i = 0; i < player0cardsDrawn; i++) {
            stateInfo += player0field[i].value + ", ";
        }
        stateInfo += "\nPlayer 1 cards: ";
        for (int i = 0; i < player1cardsDrawn; i++) {
            stateInfo += player1field[i].value + ", ";
        }
        stateInfo += "\nPlayer 0 side cards: ";
        for (int i = 0; i < 4 - player0cardsUsed; i++) {
            stateInfo += player0side[i].value + ", ";
        }
        stateInfo += "\nPlayer 1 side cards: ";
        for (int i = 0; i < 4 - player1cardsUsed; i++) {
            stateInfo += player1side[i].value + ", ";
        }
        stateInfo += "\nIs Player 0 standing: " + isPlayer0standing + "\nIs Player 1 standing: " + isPlayer1standing;
        return stateInfo;
    }

// need to see inside every array and parmeter

    //  0,   which card to play , any player, player plays a card and tells wich card is played, updating more then just the the return
    public  boolean playCard(int current_player, Cards somecard)
    {
        if(getPlayer() == current_player) {  // if it is the human players turn,
            if (current_player == 0) {
                player0field[player0cardsDrawn] = somecard;
                addPlayer0cardsUsed();
                addPlayer0cardsDrawn();
            }
            else {
                player1field[player1cardsDrawn] = somecard;
                addPlayer1cardsUsed();
                addPlayer1cardsDrawn();
            }
            updateTotals();
            return true;
        }
        else
            return false;
    }

    public boolean stand(int current_player)
    {
        if(getPlayer() == current_player) {  // if it is the human players turn,
            if (current_player == 0)
                isPlayer0standing = true;
            else
                isPlayer1standing = true;
            return true;
        }
        else
            return false;
    }


    public boolean endTurn(int current_player) // maybe a helper funtion
    {
        if(getPlayer() == current_player)

            return true;
        else
            return false;
    }

}

