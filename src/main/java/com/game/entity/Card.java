package com.game.entity;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }


    public int getRank() {
        return rank.getRank();
    }

    public String getSuit() {
        return suit.printSuit();
    }

    @Override
    public String toString() {
        return "Card{" + rank.printRank() + "-" + suit.printSuit() + '}';
    }
}
