// ChatController.java
package org.nyzz.x3.controller;


import cn.hutool.core.collection.CollUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.nyzz.x3.entity.Messages;
import org.nyzz.x3.service.ChatService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@RestController
@Tag(name = "聊天模块")
public class ChatController {

    @Resource
    private ChatService chatService;

    @GetMapping(value = "/stream/{userId}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @Operation(summary = "获取聊天")
    public SseEmitter streamMessages(@PathVariable Long userId) {
        SseEmitter emitter = new SseEmitter();

        List<Messages> messages = chatService.getMessagesByUserId(userId);

        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            try {
                if (CollUtil.isNotEmpty(messages)) {
                    // 发送消息并从列表中移除
                    Messages message = messages.remove(0);
                    emitter.send(SseEmitter.event().name("message").data(message));
                } else {
                    emitter.complete();
                }
            } catch (IOException e) {
                emitter.completeWithError(e);
            }
        }, 0, 1, TimeUnit.SECONDS);
        return emitter;
    }


}
