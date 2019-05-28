package remote_proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:10 2019/3/19
 * @Modified By:
 */
public interface MyRemote extends Remote {
    public String sayHello() throws RemoteException;
}
