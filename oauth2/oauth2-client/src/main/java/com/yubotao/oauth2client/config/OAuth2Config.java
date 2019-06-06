package com.yubotao.oauth2client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 9:41 2018/12/18
 * @Modified By:
 */
@Configuration
public class OAuth2Config {
    @Configuration
    @EnableResourceServer
    public class ResourceServerConfig  extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .csrf().disable()
                    .exceptionHandling()
                    .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                    .and()
                    .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .httpBasic();
        }

        // 解决所有报错都报401的问题，根本原因是scopedTarget.oauth2ClientContext这个bean的生成问题
        @Bean
        public RequestContextListener requestContextListener() {
            return new RequestContextListener();
        }
    }
}
