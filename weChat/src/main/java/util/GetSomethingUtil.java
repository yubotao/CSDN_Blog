package util;

import POJO.AccessToken;
import POJO.OpenId;
import com.google.gson.Gson;
import constant.WeChatConstant;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yubotao on 2017/11/16.
 */
@Service
public class GetSomethingUtil {
    
    private static final Log log = LogFactory.getLog("surferInternet");
    
    
    public String getOpenIdByCode(String code){
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + WeChatConstant.AppID + "&secret=" + WeChatConstant.AppSecret + "&code=" + code + "&grant_type=authorization_code";
    
        String message = this.surfingTheInternet(url,"GET");
        log.info("message : " + message);
    
        return message;
    }
    
    
    public String getPersonByOpenId(String accessToken,String openId){
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + accessToken + "&openid=" + openId+ "&lang=zh_CN";
    
        String message = this.surfingTheInternet(url,"GET");
        log.info("message : " + message);
        
        return message;
    }
    
    public List<String> getOpenIdList(String accessToken){
        String url = "https://api.weixin.qq.com/cgi-bin/user/get?access_token=" + accessToken + "&next_openid=";
        
        String message = this.surfingTheInternet(url,"GET");
        log.info("message : " + message);
    
        Gson gson = new Gson();
        OpenId openId = gson.fromJson(message, OpenId.class);
            
        String total = openId.getTotal();
        log.info("total : " + total);
        String count = openId.getCount();
        log.info("count : " + count);
        List<String> data = openId.getData().getOpenid();
        log.info("data : " + data);
        String next_openid = openId.getNext_openid();
        log.info("next_openid : " + next_openid);
        
        return data;
    }

    public List<String> getAccessToken(){
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + WeChatConstant.AppID + "&secret=" + WeChatConstant.AppSecret;
        
        String accessToken = null;
        String expriesIn = null;
        List<String> another = new ArrayList<String>();
            
        String message = this.surfingTheInternet(url,"GET");
            
        Gson gson = new Gson();
        AccessToken token = gson.fromJson(message, AccessToken.class);
            
        accessToken = token.getAccess_token();
        expriesIn = token.getExpires_in();
        log.info("accessToken : " + accessToken);
        log.info("expiresIn : " + expriesIn);
            
        another.add(accessToken);
        another.add(expriesIn);
        
        return another;
    }
    
    public String surfingTheInternet(String url,String method){
        String message = null;
        try {
            URL urlGet = new URL(url);
            HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
            //请求方法
            http.setRequestMethod(method);
            http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            http.setDoOutput(true);
            http.setDoInput(true);
            http.connect();
    
            InputStream is = http.getInputStream();
            int size = is.available();
            byte[] jsonBytes = new byte[size];
            is.read(jsonBytes);
            message = new String(jsonBytes, "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return message;
    }

}
