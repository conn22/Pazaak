package edu.johnsong22.pazaak;

/* @authors:
Glen Johnson, Jim Rowe, Grant Stone, James Conn
 */

public class MainDeck extends Cards {

    public MainDeck () {
        super((int) (Math.random()*10+1), false);
    }

}
