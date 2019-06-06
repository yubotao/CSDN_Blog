package com.yubotao.dynamicQueue.controller;

import com.yubotao.dynamicQueue.config.RabbitUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 11:57 2019/6/1
 * @Modified By:
 */
@RestController
public class MqController {
    @Autowired
    RabbitUtil rabbitUtil;

    @RequestMapping("/testMq")
    public String testMq(@RequestParam String msg){
        String queueName = "dynamic-queue-1";
        rabbitUtil.sendToQueue(queueName, "hello, dynamic mq!");
        String message = rabbitUtil.receiveFromQueue(queueName);
        rabbitUtil.deleteQueue(queueName);
        return message;
    }
}
