package org.nyzz.x3.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import jakarta.annotation.Resource;
import org.nyzz.x3.entity.Messages;
import org.nyzz.x3.service.ChatService;
import org.nyzz.x3.service.MessagesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@DS("slave_1")
public class ChatServiceImpl implements ChatService {

    @Resource
    private MessagesService messagesService;

    @Override
    public List<Messages> getMessagesByUserId(Long userId) {
        return messagesService.list();
    }
}
