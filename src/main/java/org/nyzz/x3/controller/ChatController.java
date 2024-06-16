// ChatController.java
package org.nyzz.x3.controller;


import org.nyzz.x3.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping(value = "/stream/{userId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter streamMessages(@PathVariable Long userId) {
        SseEmitter emitter = new SseEmitter();

//        List<Messages> messages = chatService.getMessagesByUserId(userId);
//        try {
//            emitter.send(messages);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            try {
//                List<Messages> messages = chatService.getMessagesByUserId(userId);
                emitter.send(SseEmitter.event().name("message").data("Current time: " + System.currentTimeMillis()));
            } catch (IOException e) {
                emitter.completeWithError(e);
            }
        }, 0, 1, TimeUnit.SECONDS);
        return emitter;
    }
}
