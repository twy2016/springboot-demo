package com.twy.exception.handle;

import com.twy.common.entity.R;
import com.twy.exception.exception.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试Exception异常和特殊异常处理
 *
 * @author gongpeng
 * @date 2020/12/4 9:47
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
        e.printStackTrace();
        return R.error("发生错误");
    }

    @ExceptionHandler(NullPointerException.class)
    public R handleNullPointerException(NullPointerException e) {
        e.printStackTrace();
        return R.error("发生空指针异常");
    }

    @ExceptionHandler(MyException.class)
    public R handleMyException(MyException e) {
        e.printStackTrace();
        return R.error(e.getMsg());
    }
}
