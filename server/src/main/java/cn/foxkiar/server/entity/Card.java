package cn.foxkiar.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Card implements Comparable<Card> {
    private String color;
    private Integer colorSize;
    private String type;
    private Integer number;

    /**
     * 实现接口排序规则方法 <br>
     * 先根据{@link Card#number}排序，如果相等则对{@link Card#colorSize}排序
     */
    @Override
    public int compareTo(Card card) {
        int temp;
        return (temp = card.number.compareTo(this.number)) == 0 ?
                card.colorSize.compareTo(this.colorSize) : temp;
    }
}
