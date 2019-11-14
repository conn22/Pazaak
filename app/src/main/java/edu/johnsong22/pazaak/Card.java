package edu.johnsong22.pazaak;

/* @authors:
Glen Johnson, Jim Rowe, Grant Stone, James Conn
 */

public class Card {

    protected int value;
    protected boolean fromSideDeck;
    protected boolean isFlippable;
    protected boolean isNegitive;

    public Card() {
        value = (int) (Math.random()*9)+1;
        fromSideDeck = false;
        isFlippable = false;
        isNegitive = false;
    }

    public Card(boolean sD) {
        value = (int) (Math.random()*9)+1;
        fromSideDeck = true;
        if(((int) (Math.random()*2)) == 1) {
            isFlippable = true;
            isNegitive = false;
        } else {
            isFlippable = false;
            if (((int) (Math.random()*2)) == 1) {
                isNegitive = true;
                this.value = this.getValue() * -1;
            } else {
                isNegitive = false;
            }
        }
    }

    public Card(int v, boolean sD) {
        value = v;
        fromSideDeck = sD;
        isFlippable = false;
        isNegitive = false;
    }

    public Card(Card c) {
        this.value = c.getValue();
        this.fromSideDeck = c.fromSideDeck();
        this.isNegitive = c.isNegitive();
        this.isFlippable = c.isFlippable();
    }

    public int getValue() {
        return value;
    }

    public boolean fromSideDeck() {
        return fromSideDeck;
    }

    public boolean isFlippable() {
        return isFlippable;
    }

    public boolean isNegitive() {
        return isNegitive;
    }

    public void flip () {
        value = value * -1;
    }

}
