package util;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by yubotao on 2017/11/21.
 */

/**
 * java的定时任务类Timer
 * */

public class TimerUtil extends TimerTask{
    
    private String abc;

    @Override
    public void run(){
    
        System.out.println("start");
        for(int i = 0; i < 2; i++){
            abc = "" + i;
            System.out.println("abc = " + abc);
        }
        System.out.println("end");
    }
    
    public static void main(String[] args) {
        Timer timer = new Timer();
        //Timer定时器，第一个参数delay是延迟时间，第二个参数period是时间间隔
        timer.schedule(new TimerUtil(),1000,2000);
    }

}
