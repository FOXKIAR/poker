package cn.foxkiar.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.websocket.Session;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private Session session;
    private LinkedList<Card> playerCards = new LinkedList<>();

    /**
     * 用户的出牌行为
     * @param cards 实体类列表：{@link Card}
     */
    public void discardCards(List<Card> cards) {
        for (Card card : cards)
            playerCards.remove(card);
    }

    /**
     * 用户的抽牌行为
     * @param cards 实体类列表：{@link Card}
     */
    public void drawCards(List<Card> cards) {
        playerCards.addAll(cards);
    }

    /**
     * 用户的洗牌行为
     */
    public void sortPlayerCards() {
        playerCards.sort(Card::compareTo);
    }

    /**
     * 用于判断是否获胜
     * @return {@link Boolean}
     */
    public boolean isWinVictory() {
        return !playerCards.isEmpty();
    }
}