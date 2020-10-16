package com.twy.sessionshare;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author gongpeng
 * @date 2020/10/16 15:04
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/set")
    public String set(HttpSession session) {
        session.setAttribute("user", "twy");
        return String.valueOf(port);
    }

    @GetMapping("/get")
    public String get(HttpSession session) {
        return session.getAttribute("user") + ":" + port;
    }
}
