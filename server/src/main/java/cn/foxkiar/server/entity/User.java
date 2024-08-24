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

    public void discardCardsByEntity(List<Card> cards) {
        for (Card card : cards) {
            playerCards.remove(card);
        }
    }

    public void drawCards(List<Card> cards) {
        playerCards.addAll(cards);
    }

    public void sortPlayerCards() {
        playerCards.sort(Card::compareTo);
    }

    public boolean isWinVictory() {
        return !playerCards.isEmpty();
    }
}
