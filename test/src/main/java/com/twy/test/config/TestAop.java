package com.twy.test.config;

import com.twy.test.entity.Item;
import com.twy.test.service.LoggerService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @author gongpeng
 * @date 2020/11/9 21:19
 */
@Aspect
@Component
@Slf4j
public class TestAop {

    @Resource
    private LoggerService loggerService;

    @Pointcut("@annotation(com.twy.test.config.Logger)")
    public void test() {

    }

    @AfterReturning(value = "test()", returning = "result")
    public void doAfterReturn(JoinPoint joinPoint, Item result) {
        String url = getUrl(joinPoint);
        log.info("请求路径：{}", url);
        log.info("返回结果：{}", result);
        com.twy.test.entity.Logger logger = new com.twy.test.entity.Logger();
        logger.setUrl(url);
        loggerService.save(logger);
    }

    @AfterThrowing(value = "test()", throwing = "e")
    public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
        String url = getUrl(joinPoint);
        log.info("请求路径：{}", url);
        log.info("错误信息：{}", e.getMessage());
        com.twy.test.entity.Logger logger = new com.twy.test.entity.Logger();
        logger.setUrl(url);
        loggerService.save(logger);
    }

    /**
     * 获取切面注解的请求路径
     *
     * @param joinPoint 切点
     * @return 描述信息
     * @throws Exception
     */
    private String getUrl(JoinPoint joinPoint) {
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        return method.getAnnotation(Logger.class).url();
    }

}
