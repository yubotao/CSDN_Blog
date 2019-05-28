package service.impl;

import service.TestRmiService;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 16:21 2018/3/8
 * @Modified By:
 */
public class TestRmiServiceImpl implements TestRmiService {
    public String FuckHello(String fuck) {
        return "Fuck " + fuck;
    }
}
