package com.twy.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author gongpeng
 * @date 2020/10/25 15:48
 */
@Data
@AllArgsConstructor
public class User implements Serializable {
    private String name;
    private String address;
}
