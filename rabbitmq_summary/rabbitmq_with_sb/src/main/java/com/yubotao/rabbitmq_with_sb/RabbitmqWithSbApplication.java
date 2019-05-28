package com.yubotao.rabbitmq_with_sb;

import com.yubotao.rabbitmq_with_sb.producer.MsgProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class RabbitmqWithSbApplication {

    @Autowired
    MsgProducer msgProducer;

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqWithSbApplication.class, args);
    }

    @RequestMapping(value = "/testMQ", method = RequestMethod.POST)
    public void test(@RequestParam("msg") String msg){
        msgProducer.sendMsg(msg);
    }

    @RequestMapping(value = "/testMQ/sendAll", method = RequestMethod.POST)
    public void sendAll(@RequestParam("msg") String msg){
        msgProducer.sendAll(msg);
    }

}
