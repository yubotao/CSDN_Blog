package com.yubotao.rdstest2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yubotao.rdstest2.Dao")
public class RdsTest2Application {

    public static void main(String[] args) {
        SpringApplication.run(RdsTest2Application.class, args);
    }
}
