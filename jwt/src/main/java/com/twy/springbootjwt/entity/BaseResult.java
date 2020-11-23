package com.twy.springbootjwt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author gongpeng
 * @date 2020/9/1 16:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult implements Serializable {
    /**
     * 返回code,成功为0，失败为-1
     */
    private String code;

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 返回信息
     */
    private String msg;

    public static BaseResult success(Object data, String msg) {
        return new BaseResult("0", data, msg);
    }

    public static BaseResult failed(String msg) {
        return new BaseResult("-1", null, msg);
    }
}

