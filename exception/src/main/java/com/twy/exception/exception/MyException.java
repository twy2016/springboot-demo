package com.twy.exception.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author gongpeng
 * @date 2020/12/4 12:17
 */
@AllArgsConstructor
@Data
public class MyException extends Throwable {
    private String msg;
}
