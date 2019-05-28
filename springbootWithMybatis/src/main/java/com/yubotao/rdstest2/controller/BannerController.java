package com.yubotao.rdstest2.controller;


import com.yubotao.rdstest2.POJO.Banner;
import com.yubotao.rdstest2.service.RdsService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 14:44 2018/6/4
 * @Modified By:
 */
@Controller
public class BannerController {
    private static final Log log = LogFactory.getLog(BannerController.class);

    @Autowired
    private RdsService rdsService;

    @RequestMapping(value = "/banner/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Banner get(@PathVariable String id){
        Banner banner = rdsService.getOne(id);
        log.info("banner: " + banner);
        return banner;
    }
}
