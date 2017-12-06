package com.yubotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by yubotao on 2017/12/06.
 */
@Controller
public class TilesController {
    
    @RequestMapping(value = "/tiles1",method = RequestMethod.GET)
    public String getTiles1(){
        return "tiles1";
    }
    
    @RequestMapping(value = "/tiles2",method = RequestMethod.GET)
    public String getTiles2(){
        return "tiles2";
    }
    
    @RequestMapping(value = "/noTiles",method = RequestMethod.GET)
    public String getNoTiles(){
        return "base1";
    }
    
}
