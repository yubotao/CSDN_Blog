package com.yubotao.springOAuth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringSecurityOauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityOauth2Application.class, args);
    }

    @Bean
    @Primary
    public RestTemplate loadBalancedRestTemplate(){
        return new RestTemplate();
    }
}
