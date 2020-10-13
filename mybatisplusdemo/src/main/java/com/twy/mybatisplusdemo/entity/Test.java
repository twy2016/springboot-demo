package com.twy.mybatisplusdemo.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.twy.common.entity.BaseEntity;
import lombok.Data;

/**
 * @author gongpeng
 * @date 2020/10/13 21:19
 */
@Data
@TableName("test")
public class Test extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String address;

}