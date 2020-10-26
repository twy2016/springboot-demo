package com.twy.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * @author gongpeng
 * @date 2020/10/25 15:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {
    private String name;
    private String address;

}
