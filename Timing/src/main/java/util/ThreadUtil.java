package util;


/**
 * Created by yubotao on 2017/11/21.
 */

/**
 * 通过线程实现定时
 *
 * */
public class ThreadUtil implements Runnable{
    
    
    public void run(){
        while(true){
            try{
                for(int i = 0; i < 100; i++) {
                    System.out.println("==========> come on");
                    System.out.println("it's in for : " + i);
                    System.out.println("Util Thread id :" + Thread.currentThread().getId());
                    Thread.sleep(10*1000);
                    
                }
                
                
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    
    /**
     * 就测试结果来看，确实是多线程而不是单线程
     * */
    public static void main(String[] args) {
        new Thread(new ThreadUtil()).start();
        for(int i = 0; i < 1000; i++){
            System.out.println("真的不行吗？");
            try {
                System.out.println("main Thread id :" + Thread.currentThread().getId());
                Thread.sleep(15000);
                
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        
    }
    
}
