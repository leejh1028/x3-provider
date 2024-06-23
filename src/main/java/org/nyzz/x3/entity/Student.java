package org.nyzz.x3.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Schema
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "student")
public class Student implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    @Schema(description="主键")
    private Integer id;

    @TableField(value = "`name`")
    @Schema(description="名字")
    private String name;

    @TableField(value = "age")
    @Schema(description="年纪")
    private Integer age;

    @TableField(value = "CDATE")
    @Schema(description="创建时间")
    private Date cdate;

    @TableField(value = "INPUT_DATE")
    @Schema(description="入库时间")
    private Date inputDate;

    @JsonCreator
    public Student(@JsonProperty("name") String name, @JsonProperty("age") int age) {
        this.name = name;
        this.age = age;
    }

}