package com.twy.test.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author gongpeng
 * @date 2020/11/5 9:33
 */
@Data
public class Page<T> implements Serializable {

    private static final long serialVersionUID = 8545996863226528798L;

    /**
     * 查询数据列表
     */
    protected List<T> records = Collections.emptyList();

    /**
     * 总数
     */
    protected long total = 0;

    /**
     * 每页显示条数，默认 10
     */
    protected long size = 10;

    /**
     * 当前页
     */
    protected long current = 1;
}
