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
    private LinkedList<Card> playerCards;

    /**
     * 用户出牌行为
     */
    public void discardCards(List<Card> cards) {
        playerCards.removeAll(cards);
    }

    /**
     * 用户抽牌行为
     */
    public void drawCards(List<Card> cards) {
        playerCards.addAll(cards);
    }

    /**
     * 判断用户是否获胜
     */
    public boolean isWinVictory() {
        return !playerCards.isEmpty();
    }
}