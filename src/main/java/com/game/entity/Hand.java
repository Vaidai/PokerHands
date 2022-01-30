package com.game.entity;

import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String showHand() {
        String str = "";
        for (var card : cards) {
            str += " " + card.toString();
        }
        return str;
    }

    public void printHand() {
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }

    public String findCombination() {
        return "combination is: ";
    }

    @Override
    public String toString() {
        return "Player Cards:" + cards;
    }

}
