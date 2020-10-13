package com.twy.mybatisplusdemo.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * test
 * @author 
 */
@Data
public class Test implements Serializable {
    private Integer id;

    private String name;

    private String address;

    private Date createTime;

    private String createUser;

    private Date updateTime;

    private String updateUser;
}