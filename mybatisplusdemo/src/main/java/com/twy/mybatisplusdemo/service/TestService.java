package com.twy.mybatisplusdemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.twy.mybatisplusdemo.entity.Test;

/**
 * @author gongpeng
 * @date 2020-10-13 21:12
 */
public interface TestService extends IService<Test> {
    boolean test(Test test);
}
