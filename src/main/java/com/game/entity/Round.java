package com.game.entity;

public class Round {
    private Hand player1;
    private Hand player2;

    public Round() {
    }

    public Round(Hand player1, Hand player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public Hand getPlayer1() {
        return player1;
    }

    public void setPlayer1(Hand player1) {
        this.player1 = player1;
    }

    public Hand getPlayer2() {
        return player2;
    }

    public void setPlayer2(Hand player2) {
        this.player2 = player2;
    }

    @Override
    public String toString() {
        return "Game{" +
                "player1=" + player1 +
                ", player2=" + player2 +
                '}';
    }
}
