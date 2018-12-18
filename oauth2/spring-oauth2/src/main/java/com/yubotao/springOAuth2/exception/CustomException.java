package com.yubotao.springOAuth2.exception;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 17:32 2018/12/17
 * @Modified By:
 */
public class CustomException extends RuntimeException {
    public CustomException(String msg){
        super(msg);
    }
}
