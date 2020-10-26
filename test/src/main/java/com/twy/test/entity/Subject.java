package com.twy.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gongpeng
 * @date 2020/10/26 16:06
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject implements Cloneable{
    private String name;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
