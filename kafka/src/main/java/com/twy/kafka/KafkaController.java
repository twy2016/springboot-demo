package com.twy.kafka;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author gongpeng
 * @date 2020/11/4 14:20
 */
@RestController
@RequestMapping("/kafka")
@AllArgsConstructor
public class KafkaController {

    private final KafkaSender kafkaSender;

    @GetMapping("/send")
    public String send() {
        Map<String, String> messageMap = new HashMap();
        messageMap.put("message", "我是一条消息");
        String taskId = "123456";
        String jsonStr = JSONObject.toJSONString(messageMap);
        kafkaSender.send("test", taskId, jsonStr);
        return "ok";
    }
}
