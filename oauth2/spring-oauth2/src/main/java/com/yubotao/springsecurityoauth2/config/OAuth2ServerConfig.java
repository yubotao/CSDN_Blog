package com.yubotao.springsecurityoauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.*;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;
import java.security.Principal;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:07 2018/7/26
 * @Modified By:
 */
@Configuration
public class OAuth2ServerConfig {

    private static final String DEMO_RESOURCE_ID = "order";

    @Configuration
    // 资源服务器
    @EnableResourceServer
    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
        @Autowired
        private AuthExceptionEntryPoint authExceptionEntryPoint;

        @Override
        public void configure(ResourceServerSecurityConfigurer resources){
            resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
            resources.authenticationEntryPoint(new AuthExceptionEntryPoint());
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {
            // @formatter:off
            http.exceptionHandling().authenticationEntryPoint(authExceptionEntryPoint)
                    .and()
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                    .and()
                    .requestMatchers().anyRequest()
                    .and()
                    .anonymous()
                    .and()
                    .authorizeRequests()
                    // or可以通过access_token访问，但是and不行；经过测试，应该是hasRole()方法出了问题，这里无法通过
//                    .antMatchers("/product/**").access("#oauth2.hasScope('select') and  hasRole('ROLE_ADMIN')")
                    .antMatchers("/order/**").authenticated();  // 配置order访问控制，必须认证过后才可以访问
            // @formatter:on
        }

    }

    @Configuration
//    身份认证服务器
    @EnableAuthorizationServer
    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
        @Autowired
        AuthenticationManager authenticationManager;
//        @Autowired
//        RedisConnectionFactory redisConnectionFactory;
//        @Autowired
//        UserDetailsService userDetailsService;
        @Autowired
        private DataSource dataSource;
        @Autowired
        private CustomUserDetailsService userDetailsService;


        @Override
        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
            String finalSecret = new BCryptPasswordEncoder().encode("123456");
            // 配置两个客户端，一个用于password认证，一个用于client认证
            clients.inMemory().withClient("client_1")
                    .resourceIds(DEMO_RESOURCE_ID)
                    .authorizedGrantTypes("client_credentials")
                    .scopes("select")
                    .authorities("oauth2")
                    .secret(finalSecret)
                    .and()
                    .withClient("client_2")
                    .resourceIds(DEMO_RESOURCE_ID)
                    .authorizedGrantTypes("password", "refresh_token")
                    .scopes("select")
                    .authorities("oauth2")
                    .secret(finalSecret);
        }

        // 用来对token进行相关设置，比如设置token有效时长
        @Primary
        @Bean
        public AuthorizationServerTokenServices tokenServices() {
            DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
            defaultTokenServices.setAccessTokenValiditySeconds(1000000);
            defaultTokenServices.setRefreshTokenValiditySeconds(200000);
            defaultTokenServices.setSupportRefreshToken(true);
            defaultTokenServices.setReuseRefreshToken(false);
            defaultTokenServices.setTokenStore(tokenStore());
            return defaultTokenServices;
        }

        @Bean
        @Primary
        public TokenStore tokenStore() {
//            TokenStore tokenStore = new InMemoryTokenStore();
            return new JdbcTokenStore(dataSource);
        }


        @Override
        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
            endpoints
                    .tokenStore(tokenStore())
//                    .tokenStore(new RedisTokenStore(redisConnectionFactory))
//                    .tokenServices(tokenServices())
                    .authenticationManager(authenticationManager)
                    // 没有它，在使用refresh_token的时候会报错 IllegalStateException, UserDetailsService is required.
                    .userDetailsService(userDetailsService)
                    // 不加报错"method_not_allowed",
                    .allowedTokenEndpointRequestMethods(HttpMethod.GET,HttpMethod.GET);
        }

        @Override
        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
            // 允许表单认证
            oauthServer.allowFormAuthenticationForClients();
        }
    }

}
