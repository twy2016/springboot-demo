package com.twy.springbootvalidation.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author gongpeng
 * @date 2020/8/6 13:42
 */
@Data
public class User {
    private Integer id;
    @NotNull(message = "姓名不能为空")
    private String name;
}
