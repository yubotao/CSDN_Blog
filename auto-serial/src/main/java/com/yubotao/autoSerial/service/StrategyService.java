package com.yubotao.autoSerial.service;

import com.yubotao.autoSerial.model.StrategySerial;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 12:01 2019/5/29
 * @Modified By:
 */
public interface StrategyService {
    StrategySerial getAutoSerial(String strategy) throws Exception;
}
