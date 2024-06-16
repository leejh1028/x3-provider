package org.nyzz.x3.service;

import org.nyzz.x3.entity.Messages;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ChatService {
    List<Messages> getMessagesByUserId(Long userId);
}
