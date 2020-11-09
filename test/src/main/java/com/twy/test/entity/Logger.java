package com.twy.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author gongpeng
 * @date 2020/11/9 22:02
 */
@TableName("log")
@Data
public class Logger implements Serializable {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String url;
}
