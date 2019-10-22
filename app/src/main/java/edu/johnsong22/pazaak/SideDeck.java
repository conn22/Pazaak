package edu.johnsong22.pazaak;

/* @authors:
Glen Johnson, Jim Rowe, Grant Stone, James Conn
 */

public class SideDeck extends Cards {

    protected boolean isFlippable;
    protected boolean isNegitive;

    public SideDeck() {
        this.value = (int) (Math.random()*5+1);
        this.type = 1;
        if(((int) (Math.random())) == 1) {
            isFlippable = true;
            isNegitive = false;
        } else {
            isFlippable = false;
            if (((int) (Math.random())) == 1) {
                isNegitive = true;
                this.value = this.getValue() * -1;
            } else {
                isNegitive = false;
            }
        }
    }

    @Override
    public int getValue() {
        return super.getValue();
    }

    @Override
    public int getType() {
        return super.getType();
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
