package edu.johnsong22.pazaak;

/* @authors:
Glen Johnson, Jim Rowe, Grant Stone, James Conn
 */

public class Card {

    protected int value;
    protected boolean fromSideDeck;
    protected boolean isFlippable;
    protected boolean isNegitive;
    
    //constructor to randomly generate a main card
    public Card() {
        value = (int) (Math.random()*9)+1;
        fromSideDeck = false;
        isFlippable = false;
        isNegitive = false;
    }
    
    //constructor for a side deck card
    public Card(int v, boolean sD, boolean flip, boolean neg) {
        value = v;
        fromSideDeck = sD;
        isFlippable = flip;
        isNegitive = neg;
    }
    
    //deepcopy constructor
    public Card(Card c) {
        this.value = c.getValue();
        this.fromSideDeck = c.fromSideDeck();
        this.isNegitive = c.isNegitive();
        this.isFlippable = c.isFlippable();
    }
    
    //randomly generates a side deck card (for alpha version)
    public Card(boolean sD) {
        value = (int) (Math.random()*5 )+1;
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
    
    //creates a basic side deck card (for testing)
    public Card(int v, boolean sD) {
        value = v;
        fromSideDeck = sD;
        isFlippable = false;
        isNegitive = false;
    }
    
    //flips the value of a card, if the card is flippable
    public void flip () {
        value = value * -1;
    }

    //getters for class attributes
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

}
