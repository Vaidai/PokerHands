package com.game.FactoryPattern;

public class Flush extends Strategy{
    @Override
    public void getRate() {
        rate = 500;
    }
}
