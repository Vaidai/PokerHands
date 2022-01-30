package com.game.FactoryPattern;

import com.game.entity.Card;

import java.util.List;

public abstract class Strategy {
    protected int rate;

    public abstract void getRate();

    public int calculateResult(List<Card> cards) {
        return cards.stream().mapToInt(Card::getRank).sum() + rate;
    }
}
