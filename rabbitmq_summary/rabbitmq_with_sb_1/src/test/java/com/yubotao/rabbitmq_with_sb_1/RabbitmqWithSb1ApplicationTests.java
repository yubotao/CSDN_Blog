package com.yubotao.rabbitmq_with_sb_1;

import com.yubotao.rabbitmq_with_sb_1.many2one.PaymentNotifySender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqWithSb1ApplicationTests {

    @Autowired
    PaymentNotifySender sender;

    @Test
    public void contextLoads() {
    }

    @Test
    public void test_sender_many2one_1() throws Exception{
        for (int i = 0; i < 20; i+=2){
            sender.sender("支付订单号："+i);
            Thread.sleep(1000);
        }
    }

    @Test
    public void test_sender_many2one_2() throws Exception {
        for (int i = 1; i < 20; i+=2) {
            sender.sender("支付订单号："+i);
            Thread.sleep(1000);
        }
    }


}
