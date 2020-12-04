package com.twy.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author gongpeng
 * @date 2020/11/13 22:01
 */
@Data
public class R<T> implements Serializable {

    private Integer code;

    private String message;

    private T data;

    public static <T> R<T> ok() {
        return restResult(null, ResultCode.SUCCESS, (String) null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(data, ResultCode.SUCCESS, (String) null);
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(data, ResultCode.SUCCESS, msg);
    }

    public static <T> R<T> error() {
        return restResult(null, ResultCode.ERROR, (String) null);
    }

    public static <T> R<T> error(String msg) {
        return restResult(null, ResultCode.ERROR, msg);
    }

    public static <T> R<T> error(T data) {
        return restResult(data, ResultCode.ERROR, (String) null);
    }

    public static <T> R<T> error(T data, String msg) {
        return restResult(data, ResultCode.ERROR, msg);
    }

    private static <T> R<T> restResult(T data, int code, String msg) {
        R<T> apiResult = new R();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMessage(msg);
        return apiResult;
    }

}
