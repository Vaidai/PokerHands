package com.game;

import com.game.entity.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();


    @Test
    void shouldGetTheWinner_player1() {
        Round round = new Round(
                new Hand(Arrays.asList(new Card(Rank.ACE, Suit.C), new Card(Rank.QUEEN, Suit.C), new Card(Rank.JACK, Suit.C), new Card(Rank.KING, Suit.C), new Card(Rank.TEN, Suit.C))),
                new Hand(Arrays.asList(new Card(Rank.ACE, Suit.D), new Card(Rank.QUEEN, Suit.C), new Card(Rank.JACK, Suit.C), new Card(Rank.KING, Suit.C), new Card(Rank.TEN, Suit.C)))
        );

        assertEquals("PLAYER 1", game.findTheWinner(round));
    }


    @Test
    void shouldGetTheWinner_player2() {
        Round round = new Round(
                new Hand(Arrays.asList(new Card(Rank.ACE, Suit.D), new Card(Rank.QUEEN, Suit.C), new Card(Rank.JACK, Suit.C), new Card(Rank.KING, Suit.C), new Card(Rank.TEN, Suit.C))),
                new Hand(Arrays.asList(new Card(Rank.ACE, Suit.C), new Card(Rank.QUEEN, Suit.C), new Card(Rank.JACK, Suit.C), new Card(Rank.KING, Suit.C), new Card(Rank.TEN, Suit.C)))
        );

        assertEquals("PLAYER 2", game.findTheWinner(round));
    }

    @Test
    void shouldGetCardValue_royalFlushWith_1060() {
        List<Card> cards = Arrays.asList(new Card(Rank.ACE, Suit.C), new Card(Rank.QUEEN, Suit.C), new Card(Rank.JACK, Suit.C), new Card(Rank.KING, Suit.C), new Card(Rank.TEN, Suit.C));
        //RoyalFlush = 10+11+12+13+14+1000=1060
        assertEquals(1060, game.getCardValueResult(cards));
    }

    @Test
    void shouldGetCardValue_straightFlushWith_955() {
        List<Card> cards = Arrays.asList(new Card(Rank.NINE, Suit.C), new Card(Rank.TEN, Suit.C), new Card(Rank.JACK, Suit.C), new Card(Rank.QUEEN, Suit.C), new Card(Rank.KING, Suit.C));
        //RoyalFlush = 10+11+12+13+9+900=955
        assertEquals(955, game.getCardValueResult(cards));
    }

    @Test
    void shouldGetCardValue_forOfKindWith_849() {
        List<Card> cards = Arrays.asList(new Card(Rank.NINE, Suit.C), new Card(Rank.NINE, Suit.D), new Card(Rank.NINE, Suit.H), new Card(Rank.NINE, Suit.S), new Card(Rank.KING, Suit.C));
        //RoyalFlush = 9+9+9+9+13+700=
        assertEquals(749, game.getCardValueResult(cards));
    }

    @Test
    void shouldGetCardValue_fullHouseWith_643() {
        List<Card> cards = Arrays.asList(new Card(Rank.NINE, Suit.C), new Card(Rank.NINE, Suit.D), new Card(Rank.NINE, Suit.H), new Card(Rank.KING, Suit.S), new Card(Rank.KING, Suit.C));
        //RoyalFlush = 9+9+9+13+13+600=653
        assertEquals(653, game.getCardValueResult(cards));
    }

    @Test
    void shouldGetCardValue_flushWith_525() {
        List<Card> cards = Arrays.asList(new Card(Rank.TWO, Suit.C), new Card(Rank.EIGHT, Suit.C), new Card(Rank.FOUR, Suit.C), new Card(Rank.FIVE, Suit.C), new Card(Rank.SIX, Suit.C));
        //RoyalFlush = 2+8+4+5+6+500=525
        assertEquals(525, game.getCardValueResult(cards));
    }

    @Test
    void shouldGetCardValue_straightWith_420() {
        List<Card> cards = Arrays.asList(new Card(Rank.TWO, Suit.C), new Card(Rank.THREE, Suit.D), new Card(Rank.FOUR, Suit.H), new Card(Rank.FIVE, Suit.S), new Card(Rank.SIX, Suit.C));
        //RoyalFlush = 2+3+4+5+6+400=520
        assertEquals(420, game.getCardValueResult(cards));
    }

    @Test
    void shouldGetCardValue_threeTheSameWith_317() {
        List<Card> cards = Arrays.asList(new Card(Rank.TWO, Suit.C), new Card(Rank.TWO, Suit.D), new Card(Rank.TWO, Suit.H), new Card(Rank.FIVE, Suit.S), new Card(Rank.SIX, Suit.C));
        //RoyalFlush = 2+2+2+5+6+300=317
        assertEquals(317, game.getCardValueResult(cards));
    }

    @Test
    void shouldGetCardValue_twoPairsWith_220() {
        List<Card> cards = Arrays.asList(new Card(Rank.TWO, Suit.C), new Card(Rank.TWO, Suit.D), new Card(Rank.FIVE, Suit.H), new Card(Rank.FIVE, Suit.S), new Card(Rank.SIX, Suit.C));
        //RoyalFlush = 2+2+5+5+6+200=220
        assertEquals(220, game.getCardValueResult(cards));
    }

    @Test
    void shouldGetCardValue_onePairWith_128() {
        List<Card> cards = Arrays.asList(new Card(Rank.TWO, Suit.C), new Card(Rank.TWO, Suit.D), new Card(Rank.KING, Suit.H), new Card(Rank.FIVE, Suit.S), new Card(Rank.SIX, Suit.C));
        //RoyalFlush = 2+2+13+5+6+100=128
        assertEquals(128, game.getCardValueResult(cards));
    }

    @Test
    void shouldGetCardValue_highestCard_38() {
        List<Card> cards = Arrays.asList(new Card(Rank.TWO, Suit.C), new Card(Rank.FOUR, Suit.D), new Card(Rank.EIGHT, Suit.H), new Card(Rank.JACK, Suit.S), new Card(Rank.KING, Suit.C));
        //RoyalFlush = 2+4+8+11+13=38
        assertEquals(38, game.getCardValueResult(cards));
    }



}