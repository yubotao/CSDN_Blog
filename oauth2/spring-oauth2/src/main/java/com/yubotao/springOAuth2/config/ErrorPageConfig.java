package com.yubotao.springOAuth2.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;



/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 17:23 2018/10/10
 * @Modified By:
 */
@Component
public class ErrorPageConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry){
        ErrorPage[] errorPages = new ErrorPage[]{
                new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"),
                new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"),
                new ErrorPage(Throwable.class, "/error/500")
        };
        registry.addErrorPages(errorPages);

    }

}
