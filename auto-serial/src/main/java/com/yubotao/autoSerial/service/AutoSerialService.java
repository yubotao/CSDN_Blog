package com.yubotao.autoSerial.service;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 12:01 2019/5/29
 * @Modified By:
 */
public interface AutoSerialService {
    String nextSerial(String strategy) throws Exception;
}
