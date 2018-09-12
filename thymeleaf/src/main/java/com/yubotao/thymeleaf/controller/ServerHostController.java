package com.yubotao.thymeleaf.controller;

import com.yubotao.thymeleaf.properties.ServerHostProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 19:18 2018/9/10
 * @Modified By:
 */
@Controller
@RequestMapping(path = "/server")
public class ServerHostController {

    @Autowired
    private ServerHostProperties serverHostProperties;

    @RequestMapping("/showServerHost")
    public String serverHost(Model model){
        List<ServerHostProperties.InetAddress> inetAddresses = new ArrayList<ServerHostProperties.InetAddress>();
        inetAddresses.add(serverHostProperties.getInetAddressA());
        inetAddresses.add(serverHostProperties.getInetAddressB());
        inetAddresses.add(serverHostProperties.getInetAddressC());
        model.addAttribute("inetAddresses", inetAddresses);

        return "showServerHost";
    }

}
