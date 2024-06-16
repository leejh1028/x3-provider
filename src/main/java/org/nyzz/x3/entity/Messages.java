package org.nyzz.x3.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

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
    private Object sender;

    @TableField(value = "message")
    @Schema(description="")
    private String message;

    @TableField(value = "`timestamp`")
    @Schema(description="")
    private LocalDateTime timestamp = LocalDateTime.now();

    public enum Sender {
        USER,
        BOT
    }
}