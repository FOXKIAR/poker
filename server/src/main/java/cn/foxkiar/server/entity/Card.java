package cn.foxkiar.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    private String color;
    private Integer colorSize;
    private String type;
    private Integer number;

    public int compareTo(Card card) {
        int temp;
        return (temp = this.number.compareTo(card.number)) == 0 ?
                card.colorSize.compareTo(this.colorSize) : temp;
    }
}
