package com.twy.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author gongpeng
 * @date 2020/10/25 15:48
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Cloneable {
    private String name;
    private String address;
    private Subject subject;

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        User user = (User) super.clone();
        user.subject = (Subject) subject.clone();
        return user;
    }
}
