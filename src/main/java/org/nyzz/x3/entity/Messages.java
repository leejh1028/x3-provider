package org.nyzz.x3.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

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
    private Sender sender;

    @TableField(value = "message")
    @Schema(description="")
    private String message;

    @TableField(value = "`timestamp`")
    @Schema(description="")
    private LocalDateTime timestamp = LocalDateTime.now();

    @Getter
    public enum Sender {

        USER("user", 1), BOT("bot", 2);

        @EnumValue
        private final String name;

        @JsonValue
        private final Integer num;

        Sender(String name, Integer num) {
            this.name = name;
            this.num = num;
        }
    }

}