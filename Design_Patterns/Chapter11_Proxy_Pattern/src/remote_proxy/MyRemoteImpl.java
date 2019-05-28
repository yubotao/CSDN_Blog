package remote_proxy;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:11 2019/3/19
 * @Modified By:
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    public String sayHello(){
        return "Sever says, 'Hey'";
    }

    public MyRemoteImpl() throws RemoteException{}

    public static void main(String[] args) {
        try{
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("RemoteHello", service);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
