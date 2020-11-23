package com.twy.springbootjwt.service;

import com.twy.springbootjwt.entity.BaseResult;
import com.twy.springbootjwt.entity.User;
import com.twy.springbootjwt.mapper.UserMapper;
import com.twy.springbootjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gongpeng
 * @date 2020/9/1 16:05
 */
@Service("userService")
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public String login(String userName, String password) {
        String token = null;
        User user = userMapper.findByUserName(userName);
        if (user == null) {
            BaseResult.failed("用户名不正确");
        } else {
            if (!user.getPassword().equals(password)) {
                BaseResult.failed("密码不正确");
            } else {
                token = JwtUtil.sign(user.getId(), userName, password);
            }
        }
        return token;
    }

}
