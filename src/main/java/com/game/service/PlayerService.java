package com.game.service;

import com.game.entity.*;

import java.util.ArrayList;
import java.util.List;

public class PlayerService {

    public Round getGamePlayers(String line) {
        Hand player1 = getPlayer(line.substring(0, line.length() / 2));
        Hand player2 = getPlayer(line.substring((line.length() / 2) + 1));

        return new Round(player1, player2);
    }

    public Hand getPlayer(String substring) {
        var elements = substring.split(" ");
        List<Card> cards = new ArrayList<>();

        for (var e : elements) {
            var i = e.split("");

            var rank = Rank.customValueOf(i[0]);
            var suit = Suit.valueOf(i[1]);

            Card card = new Card(rank, suit);
            cards.add(card);
        }
        return new Hand(cards);
    }
}
