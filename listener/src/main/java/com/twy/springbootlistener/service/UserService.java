package com.twy.springbootlistener.service;

import com.twy.springbootlistener.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author gongpeng
 * @date 2020/8/11 15:56
 */
@Service
public class UserService {

    public User getUser(){
        return new User(1,"唐万言","123456");
    }
}
