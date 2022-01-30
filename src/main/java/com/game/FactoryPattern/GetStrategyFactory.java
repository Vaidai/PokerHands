package com.game.FactoryPattern;

import com.game.entity.Card;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class GetStrategyFactory {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private final int HIGHEST_VALUE = 14;

    public Strategy getStrategy(List<Card> cards) {

        if (isSameSuitCards(cards) && isCardsIsStraight(cards) && getHighestValue(cards) == HIGHEST_VALUE) {
            LOGGER.info("Royal Flush");
            return new RoyalFlush();
        } else if (isSameSuitCards(cards) && isCardsIsStraight(cards) && getHighestValue(cards) < HIGHEST_VALUE) {
            LOGGER.info("Straight Flush");
            return new StraightFlush();
        } else if (fourCardsTheSameRank(cards)) {
            LOGGER.info("Four of a Kind");
            return new FourOfAKind();
        } else if (hasThreeCardsWithTheSameRank(cards) && pairsCount(cards) == 1) {
            LOGGER.info("Full House");
            return new FullHouse();
        } else if (isSameSuitCards(cards) && !isCardsIsStraight(cards)) {
            LOGGER.info("Flush");
            return new Flush();
        } else if (isCardsIsStraight(cards) && !isSameSuitCards(cards)) {
            LOGGER.info("Straight");
            return new Straight();
        } else if (hasThreeCardsWithTheSameRank(cards)) {
            LOGGER.info("Three of a Kind");
            return new ThreeOfAKind();
        } else if (pairsCount(cards) == 2) {
            LOGGER.info("Two Pairs");
            return new TwoPairs();
        } else if (pairsCount(cards) == 1) {
            LOGGER.info("One Pair");
            return new OnePair();
        } else {
            LOGGER.info("Just Highest Card!");
            return new HighCard();
        }
    }

    private boolean fourCardsTheSameRank(List<Card> cards) {
        var smth = cards.stream().collect(Collectors.groupingBy(Card::getRank));

        for (var one : smth.entrySet()) {
            if (one.getValue().size() == 4) {
                return true;
            }
        }
        return false;
    }

    private int pairsCount(List<Card> cards) {
        var smth = cards.stream().collect(Collectors.groupingBy(Card::getRank));

        int pairs = 0;
        for (var one : smth.entrySet()) {
            if (one.getValue().size() == 2) {
                pairs++;
            }
        }
        return pairs;
    }

    private boolean hasThreeCardsWithTheSameRank(List<Card> cards) {
        var smth = cards.stream().collect(Collectors.groupingBy(Card::getRank));

        for (var one : smth.entrySet()) {
            if (one.getValue().size() == 3) {
                return true;
            }
        }
        return false;
    }

    private int getHighestValue(List<Card> cards) {
        return cards.stream().max(Comparator.comparing(Card::getRank)).get().getRank();
    }

    private boolean isSameSuitCards(List<Card> cards) { //Flush
        return cards.stream().allMatch(card -> card.getSuit().equals(cards.get(0).getSuit()));
    }

    private boolean isCardsIsStraight(List<Card> cards) {
        var cardsSortedByRank = cards.stream().sorted(Comparator.comparing(Card::getRank)).collect(Collectors.toList());

        boolean isStraight = false;
        for (int i = 0; i < cardsSortedByRank.size() - 1; i++) {
            if (cardsSortedByRank.get(i).getRank() + 1 == cardsSortedByRank.get(i + 1).getRank()) {
                isStraight = true;
            } else {
                break;
            }
        }
        return isStraight;
    }

}
