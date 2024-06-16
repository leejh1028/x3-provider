package org.nyzz.x3.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * 用户信息表
 */
@Schema(description="用户信息表")
@Data
@Builder
@AllArgsConstructor
@TableName(value = "users")
public class Users {
    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description="")
    private Integer id;

    @TableField(value = "username")
    @Schema(description="")
    private String username;

    @TableField(value = "created_at")
    @Schema(description="")
    private Date createdAt;
}