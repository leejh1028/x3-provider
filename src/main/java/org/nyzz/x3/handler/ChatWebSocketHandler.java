package org.nyzz.x3.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.TextMessage;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class ChatWebSocketHandler extends TextWebSocketHandler {

    private static final Set<WebSocketSession> onLinesSessions = Collections.synchronizedSet(new HashSet<>());

    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
        log.info("afterConnectionEstablished，ID：{}--{}", session.getId(), session.getAttributes().get("name"));
        onLinesSessions.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        log.info("收到来自【 {} 】的消息：{}", session.getId(), message.getPayload());
//        for (WebSocketSession s : onLinesSessions) {
//            s.sendMessage(message);
//        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        log.error("afterConnectionClosed");
        onLinesSessions.remove(session);
    }

    public static void broadcast(String message) throws Exception {
        synchronized (onLinesSessions) {
            for (WebSocketSession session : onLinesSessions) {
                if (session.isOpen()) {
                    session.sendMessage(new TextMessage(message));
                }
            }
        }
    }

}
