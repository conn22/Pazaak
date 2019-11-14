package edu.johnsong22.pazaak;

import org.junit.Test;

import static org.junit.Assert.*;

public class PazaakGameStateTest {

    @Test
    public void getPlayer() throws Exception {
        PazaakGameState p = new PazaakGameState();
        p.setPlayer(1);
        assertEquals(p.getPlayer(), 1);
        p.setPlayer(0);
        assertEquals(p.getPlayer(), 0);
    }

    @Test
    public void getNextPlayer() throws Exception {
        PazaakGameState p = new PazaakGameState();
        int lastPlayer = p.getPlayer();
        p.setPlayer(p.getNextPlayer());
        p.setPlayer(p.getNextPlayer());
        if (lastPlayer == 1) {
            assertEquals(p.getPlayer(), 1);
        } else {
            assertEquals(p.getPlayer(), 0);
        }
    }

    @Test
    public void getPlayer0wins() throws Exception {
    }

    @Test
    public void getPlayer0total() throws Exception {
    }

    @Test
    public void getPlayer0cardsDrawn() throws Exception {
    }

    @Test
    public void getPlayer0cardsUsed() throws Exception {
    }

    @Test
    public void getPlayer0field() throws Exception {
    }

    @Test
    public void getPlayer0side() throws Exception {
    }

    @Test
    public void getPlayer1wins() throws Exception {
    }

    @Test
    public void getPlayer1total() throws Exception {
    }

    @Test
    public void getPlayer1field() throws Exception {
    }

    @Test
    public void getPlayer1side() throws Exception {
    }

    @Test
    public void setPlayer() throws Exception {
    }

    @Test
    public void addPlayer0cardsDrawn() throws Exception {
    }

    @Test
    public void addPlayer1cardsDrawn() throws Exception {
    }

    @Test
    public void addPlayer0cardsUsed() throws Exception {
    }

    @Test
    public void addPlayer1cardsUsed() throws Exception {
    }

    @Test
    public void getPlayer1cardsDrawn() throws Exception {
    }

    @Test
    public void getIsPlayer0Standing() throws Exception {
    }

    @Test
    public void getIsPlayer1Standing() throws Exception {
    }

    @Test
    public void getPlayer1cardsUsed() throws Exception {

    }

    @Test
    public void updateTotals() throws Exception {

    }

    @Test
    public void onNewTurn() throws Exception {
        PazaakGameState p = new PazaakGameState();
        p.setPlayer(0);
        p.onNewTurn();
        assertEquals(p.getPlayer0total(), p.getPlayer0field()[p.getPlayer0cardsDrawn()-1].getValue());
    }

    @Test
    public void toString1() throws Exception {

    }

    @Test
    public void playCard() throws Exception {
        PazaakGameState p = new PazaakGameState();
        Card card = new Card(true);

        p.setPlayer(0);

        p.playCard(p.getPlayer(), card);
        assertEquals(p.getPlayer0total(), card.getValue());

        p.setPlayer(1);
        p.playCard(0,card);

        assertNotEquals(p.getPlayer1total(), card.getValue());

    }

    @Test
    public void stand() throws Exception {
        PazaakGameState p = new PazaakGameState();
        p.setPlayer(0);
        assertTrue(p.stand(p.getPlayer()));
        assertTrue(p.getIsPlayer0Standing());
        assertFalse(p.stand(0));
        assertFalse(p.getIsPlayer1Standing());


    }

    @Test
    public void endTurn() throws Exception {
        PazaakGameState p = new PazaakGameState();
        p.setPlayer(1);
        assertTrue(p.endTurn(p.getPlayer()));
        assertEquals(p.getPlayer(), 0);
        assertFalse(p.endTurn(1));
    }
}