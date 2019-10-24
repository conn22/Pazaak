package edu.johnsong22.pazaak;

/* @authors:
Glen Johnson, Jim Rowe, Grant Stone, James Conn
 */

public class MainDeck extends Cards {

    public MainDeck () {
        this.value = (int) (Math.random()*8+1);
        this.type = 0;
    }

    @Override
    public int getValue() {
        return super.getValue();
    }

    @Override
    public int getType() {
        return super.getType();
    }

}
