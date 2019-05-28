package remote_proxy;

import java.rmi.Naming;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:15 2019/3/19
 * @Modified By:
 */
public class MyRemoteClient {
    public static void main(String[] args) {
        new MyRemoteClient().go();
    }

    public void go(){
        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/RemoteHello");
            String s = service.sayHello();
            System.out.println(s);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
