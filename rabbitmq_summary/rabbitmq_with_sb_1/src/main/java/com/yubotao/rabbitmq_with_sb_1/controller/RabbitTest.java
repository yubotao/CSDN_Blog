package com.yubotao.rabbitmq_with_sb_1.controller;

import com.yubotao.rabbitmq_with_sb_1.topic.TopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:46 2018/11/22
 * @Modified By:
 */
@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

    @Autowired
    private TopicSender topicSender;

    /**
     * topic exchange类型rabbitmq测试
     */
    @PostMapping("/topicTest")
    public void topicTest() {
        topicSender.send();
    }

}
