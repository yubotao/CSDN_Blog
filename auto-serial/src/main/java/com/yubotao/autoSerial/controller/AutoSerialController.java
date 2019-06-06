package com.yubotao.autoSerial.controller;

import com.yubotao.autoSerial.service.AutoSerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: yubotao
 * @Description:
 * @Date: Created in 15:30 2019/5/29
 * @Modified By:
 */
@RestController
public class AutoSerialController {

    @Autowired
    AutoSerialService autoSerialService;

    @RequestMapping(value = "/getNextSerial", method = RequestMethod.GET)
    public String getNextSerial(){
        try {
            return autoSerialService.nextSerial("stepOneSerial");
        }catch (Exception e){
            return "Failed";
        }
    }
}
