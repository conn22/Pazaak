package edu.johnsong22.pazaak;

/* @authors:
Glen Johnson, Jim Rowe, Grant Stone, James Conn
 */

public class Cards {

    protected int value;
    protected boolean fromSideDeck;

    public Cards(int v, boolean sD) {
        value = v;
        fromSideDeck = sD;
    }

    public int getValue() {
        return value;
    }

    public boolean fromSideDeck() {
        return fromSideDeck;
    }

}
