package org.nyzz.x3.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * 聊天消息表
 */
@Schema(description="聊天消息表")
@Data
@Builder
@AllArgsConstructor
@TableName(value = "messages")
public class Messages {
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description="")
    private Integer id;

    @TableField(value = "user_id")
    @Schema(description="")
    private Integer userId;

    @TableField(value = "sender")
    @Schema(description="")
    private SenderEnum senderEnum;

    @TableField(value = "message")
    @Schema(description="")
    private String message;

    @TableField(value = "`timestamp`")
    @Schema(description="")
    private LocalDateTime timestamp = LocalDateTime.now();

    @Getter
    public enum SenderEnum {

        USER("user", 1), BOT("bot", 2);

//        标记数据库存的具体值
        @EnumValue
        private final String name;

//        标记序列化时要返回的值，效果：数据库存的user，但返回1
        @JsonValue
        private final Integer num;

        SenderEnum(String name, Integer num) {
            this.name = name;
            this.num = num;
        }
    }

}

/*
* CREATE TABLE `messages` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int DEFAULT NULL,
  `senderEnum` enum('user','bot') DEFAULT NULL,
  `message` text,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='聊天消息表';
* */