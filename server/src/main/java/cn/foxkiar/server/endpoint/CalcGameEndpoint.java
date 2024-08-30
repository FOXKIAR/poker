package cn.foxkiar.server.endpoint;

import cn.foxkiar.server.entity.Card;
import cn.foxkiar.server.entity.User;
import cn.foxkiar.server.utils.PokerStructureUtil;
import org.springframework.stereotype.Component;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;


@Component
@ServerEndpoint(value = "{username}/calc/{room}")
public class CalcGameEndpoint {
    private String room;
    private final List<User> users = new ArrayList<>();
    private final List<Card> fieldCards = new LinkedList<>();

    private final CopyOnWriteArraySet<CalcGameEndpoint> calcGames = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username, @PathParam("room") String room) {
        this.room = room;
        User user =new User(username, session, new LinkedList<>());
        // LinkedList 在多修改少读取的情况下效率高
        this.fieldCards.addAll(PokerStructureUtil.noJoker());
        if (calcGames.contains(this)) {
            for (CalcGameEndpoint temp : this.calcGames) {
                if (temp.equals(this))
                    temp.users.add(user); break;
            }
        }
        calcGames.add(this);
    }


    private void sendNewUserMsg(List<User> toUsers, User newUser) throws IOException {
        for (User user : toUsers) {
            user.getSession().getBasicRemote().sendText(newUser.getUsername() + "加入房间");
        }
    }

    /**
     * 重写父类对象{@link Object#equals(Object obj)}方法以简化判断是否存在逻辑
     * @param obj 父类对象{@link Object#equals(Object obj)}方法固定参数
     * @return {@link CalcGameEndpoint}类型时，比较两者之间的{@link CalcGameEndpoint#room}成员变量 <br>
     * 非{@link CalcGameEndpoint}类型时，false
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof CalcGameEndpoint &&
                this.room.equals(((CalcGameEndpoint) obj).room);
    }
}
