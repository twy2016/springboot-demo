package com.twy.springbootjwt.interceptor;

import com.auth0.jwt.JWT;
import com.twy.springbootjwt.annotation.TokenRequired;
import com.twy.springbootjwt.entity.User;
import com.twy.springbootjwt.mapper.UserMapper;
import com.twy.springbootjwt.service.UserService;
import com.twy.springbootjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author gongpeng
 * @date 2020/9/1 16:28
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从http请求头中取出token
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(TokenRequired.class)) {
            TokenRequired userLoginToken = method.getAnnotation(TokenRequired.class);
            if (userLoginToken.required()) {
                //进行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                //获取userId
                Long userId = JWT.decode(token).getClaim("userId").asLong();
                User user = userMapper.findUserIdById(userId);
                if (user == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }
                if (!JwtUtil.verity(token, user.getPassword())) {
                    throw new RuntimeException("无效的令牌");
                }
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
