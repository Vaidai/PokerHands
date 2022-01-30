package com.game;

import com.game.FactoryPattern.GetStrategyFactory;
import com.game.FactoryPattern.Strategy;
import com.game.entity.Card;
import com.game.entity.Round;
import com.game.service.InputDataReader;
import com.game.service.PlayerService;

import java.util.List;
import java.util.logging.Logger;

public class Game {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public void play(String fileName) {

        List<String> input = InputDataReader.ReadFile(fileName);

        for (var round : input) {
            PlayerService playerService = new PlayerService();
            Round roundPlayers = playerService.getGamePlayers(round);

            String winner = findTheWinner(roundPlayers);
            LOGGER.info("Winner is: " + winner);
        }
    }

    public String findTheWinner(Round roundPlayers) {

        var player1 = getCardValueResult(roundPlayers.getPlayer1().getCards());
        var player2 = getCardValueResult(roundPlayers.getPlayer2().getCards());

        LOGGER.info("Player1: " + player1 + " : " + player1 + " PLayer2");
        return (player1 > player2) ? "PLAYER 1" : "PLAYER 2";
    }

    public int getCardValueResult(List<Card> cards) {
        GetStrategyFactory strategy = new GetStrategyFactory();
        Strategy player = strategy.getStrategy(cards);
        player.getRate();

        return player.calculateResult(cards);
    }

}
