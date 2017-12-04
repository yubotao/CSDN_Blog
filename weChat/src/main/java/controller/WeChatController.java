package controller;

import POJO.OpenIdByCode;
import POJO.Person;
import com.google.gson.Gson;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.GetSomethingUtil;
import util.SignUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by yubotao on 2017/11/15.
 */

@Controller
public class WeChatController {
    
    private static final Log log = LogFactory.getLog("wx");
    
    /**
     * 和微信接入
     * */
    @RequestMapping(value = "/wx",method = RequestMethod.GET)
    public void get(HttpServletRequest request, HttpServletResponse response){
        
        
        // 微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
        String signature = request.getParameter("signature");
        //时间戳
        String timestamp = request.getParameter("timestamp");
        //随机数
        String nonce = request.getParameter("nonce");
        //随机字符串
        String echostr = request.getParameter("echostr");
    
        PrintWriter out = null;
        
        try{
            out = response.getWriter();
            // 通过检验signature对请求进行校验，若校验成功则原样返回echostr，否则接入失败
            if(SignUtil.checkSignature(signature,timestamp,nonce)){
                out.print(echostr);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            out.close();
            out = null;
        }
        
    }
    
    @Autowired
    GetSomethingUtil token;
    
    /**
     *获取2小时的AccessToken
     */
    @RequestMapping(value = "/a/wx/accessToken",method = RequestMethod.GET)
    public String getAccessToken(HttpServletRequest request, HttpServletResponse response, Model model){
    
        List<String> tokenList = token.getAccessToken();
        
        log.info("tokenList : " + tokenList);
        
        String accessToken = tokenList.get(0);
        String expiresIn = tokenList.get(1);
    
        model.addAttribute("accessToken",accessToken);
        model.addAttribute("expiresIn",expiresIn);
        
        return "tokenTest";
    }
    
    /**
     *通过AccessToken获取关注的用户的openId列表
     *  @param accessToken
     */
    @RequestMapping(value = "/a/wx/openId",method = RequestMethod.GET)
    public String getOpenId(HttpServletRequest request,HttpServletResponse response,Model model,String accessToken){
        List<String> data = token.getOpenIdList(accessToken);
        
        log.info("data : " + data);
        
        model.addAttribute("data",data);
        
        return "openIdTest";
    }
    
    
    /**
     *通过AccessToken和openId获取用户的基本信息
     * @param accessToken
     * @param openId
     */
    @RequestMapping(value = "/a/wx/person",method = RequestMethod.GET)
    public String getPerson(HttpServletRequest request,HttpServletResponse response,Model model,String accessToken,String openId){
        String message = token.getPersonByOpenId(accessToken,openId);
        
        log.info("message : " + message);
    
        Gson gson = new Gson();
        Person person = gson.fromJson(message, Person.class);
        
        String subscribe = person.getSubscribe();
        String openid = person.getOpenid();
        String nickname = person.getNickname();
        String sex = person.getSex();
        String language = person.getLanguage();
        String city = person.getCity();
        String province = person.getProvince();
        String country = person.getCountry();
        String headimgurl = person.getHeadimgurl();
        String subscribe_time = person.getSubscribe_time();
        String unionid = person.getUnionid();
        String remark = person.getRemark();
        String groupid = person.getGroupid();
        List<String> tagid_list = person.getTagid_list();
        
        model.addAttribute("subscribe",subscribe);
        model.addAttribute("openid",openid);
        model.addAttribute("nickname",nickname);
        model.addAttribute("sex",sex);
        model.addAttribute("language",language);
        model.addAttribute("city",city);
        model.addAttribute("province",province);
        model.addAttribute("country",country);
        model.addAttribute("headimgurl",headimgurl);
        model.addAttribute("subscribe_time",subscribe_time);
        model.addAttribute("unionid",unionid);
        model.addAttribute("remark",remark);
        model.addAttribute("groupid",groupid);
        model.addAttribute("tagid_list",tagid_list);
        
        return "personTest";
    }

    
    
    
}
