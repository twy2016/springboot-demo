package com.twy.mybatisplusdemo.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.twy.common.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gongpeng
 * @date 2020/10/13 21:19
 */
@Data
@TableName("test")
@AllArgsConstructor
@NoArgsConstructor
public class Test extends BaseEntity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String address;

    @Version
    private Integer version;

    @TableLogic(delval = "-1")
    private Integer delFlag;

    public Test(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}