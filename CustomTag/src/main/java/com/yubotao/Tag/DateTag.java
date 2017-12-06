package com.yubotao.Tag;


import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Administrator on 2017/08/18.
 */
public class DateTag extends TagSupport {
    
    private Long value;
    
    @Override
    public int doStartTag() throws JspException {
        String vv = "" + value;
        long time = Long.valueOf(vv);
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = dateFormat.format(c.getTime());
        try{
            pageContext.getOut().write(s);
        }catch (IOException e){
            e.printStackTrace();
        }
        
        return super.doStartTag();
    }
    
    public void setValue(Long value){
        this.value = value;
    }
    
}
