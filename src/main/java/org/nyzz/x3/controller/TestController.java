package org.nyzz.x3.controller;

import com.alibaba.fastjson.JSON;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.nyzz.x3.entity.Messages;
import org.nyzz.x3.entity.Student;
import org.nyzz.x3.handler.ChatWebSocketHandler;
import org.nyzz.x3.service.MessagesService;
import org.nyzz.x3.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
@Tag(name = "测试管理")
@Slf4j
public class TestController {
    
    @Autowired
    private StudentService studentService;

    @Resource
    private MessagesService messagesService;

    @Resource
    private ChatWebSocketHandler chatWebSocketHandler;

    @GetMapping("/sendMsg")
    @Operation(summary = "WS发送消息")
    public boolean sendMessage(String msg) throws Exception {
        ChatWebSocketHandler.broadcast(msg);
        return true;
    }


    @PostMapping("/saveStudent")
    @Operation(summary = "保存学生")
    public boolean add(@RequestBody Student student) {
//        return studentService.save(user);
        log.error(JSON.toJSONString(student));
        return true;
    }

    @GetMapping("/getMessage")
    @Operation(summary = "测试获取枚举数据")
    public Messages getMessage() {
        return messagesService.getMessages();
    }

}
