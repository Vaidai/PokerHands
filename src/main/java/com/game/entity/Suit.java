package com.game.entity;

public enum Suit {
    H("H"),
    S("S"),
    D("D"),
    C("C");


    private final String suitText;

    private Suit(String suitText) {
        this.suitText = suitText;
    }

    public String printSuit() {
        return suitText;
    }
}
