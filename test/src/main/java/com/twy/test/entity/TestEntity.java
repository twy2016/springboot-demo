package com.twy.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gongpeng
 * @date 2020/11/26 16:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TestEntity implements Comparable<TestEntity> {
    private Integer id;
    private String name;

    @Override
    public int compareTo(TestEntity o) {
        return o.id - this.id;
    }
}
