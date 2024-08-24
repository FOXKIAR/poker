package cn.foxkiar.server.endpoint;

import cn.foxkiar.server.entity.Card;
import org.springframework.stereotype.Component;

import javax.websocket.server.ServerEndpoint;
import java.util.List;


@Component
@ServerEndpoint(value = "/add/sub/{roomId}")
public class AddSubRoomEndpoint {
    private List<Card> fieldCards;


}
