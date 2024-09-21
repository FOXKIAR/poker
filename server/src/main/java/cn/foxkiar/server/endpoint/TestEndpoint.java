package cn.foxkiar.server.endpoint;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/test")
public class TestEndpoint {
    @OnOpen
    public void onOpen(Session session) {
        System.out.println("onOpen");
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("onClose");
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        System.out.println("onMessage: " + message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("onError: " + throwable);
    }
}
