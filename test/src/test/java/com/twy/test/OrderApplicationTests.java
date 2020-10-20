package com.twy.test;

import com.twy.test.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class OrderApplicationTests {

    @Autowired
    private OrderService orderService;

    @Test
    public void testSpringEvent() {
        orderService.order();
    }

}
