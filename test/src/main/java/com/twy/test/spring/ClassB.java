package com.twy.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author gongpeng
 * @date 2020/8/10 9:53
 */
@Component
//@AllArgsConstructor
public class ClassB {

    @Autowired
    private ClassA classA;

    public static void main(String[] args) {
        ClassA classA = new ClassA();
    }
}
