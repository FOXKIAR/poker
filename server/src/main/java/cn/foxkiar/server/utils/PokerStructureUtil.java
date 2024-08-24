package cn.foxkiar.server.utils;

import cn.foxkiar.server.entity.Card;

import java.util.ArrayList;
import java.util.List;

public class PokerStructureUtil {
    public static List<Card> noJoker() {
        List<Card> cards = new ArrayList<>();
        for (int number = 1; number <= 13; number++) {
            cards.add(new Card("黑桃", 4, calcNumber(number), number));
            cards.add(new Card("红桃", 3, calcNumber(number), number));
            cards.add(new Card("梅花", 2, calcNumber(number), number));
            cards.add(new Card("方片", 1, calcNumber(number), number));
        }
        return cards;
    }

    public static List<Card> noJoker(int count) {
        List<Card> cards = new ArrayList<>();
        while (count-- > 0) {
            cards.addAll(noJoker());
        }
        return cards;
    }

    public static List<Card> haveJoker() {
        List<Card> cards = noJoker();
        cards.add(new Card("彩色", 6, "Joker", 15));
        cards.add(new Card("黑白", 5, "Joker", 15));
        return cards;
    }

    public static List<Card> haveJoker(int count) {
        List<Card> cards = new ArrayList<>();
        while (count-- > 0) {
            cards.addAll(haveJoker());
        }
        return cards;
    }

    private static String calcNumber(int number) {
        if (number == 11) return "J";
        if (number == 12) return "Q";
        if (number == 13) return "K";
        if (number == 1) return "A";
        return String.valueOf(number);
    }
}
