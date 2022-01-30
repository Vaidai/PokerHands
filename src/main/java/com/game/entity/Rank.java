package com.game.entity;

public enum Rank {
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "T"),
    JACK(11, "J"),
    QUEEN(12, "Q"),
    KING(13, "K"),
    ACE(14, "A");

    private final int rankValue;
    private final String rankString;

    private Rank(int rankValue, String rankString) {
        this.rankValue = rankValue;
        this.rankString = rankString;
    }


    public int getRank() {
        return rankValue;
    }

    public String printRank() {
        return rankString;
    }

    public static Rank customValueOf(Object value) {
        for (Rank v : values())
            if (v.rankString.equals(value)) return v;
        throw new IllegalArgumentException();
    }

}
