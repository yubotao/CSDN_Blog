package dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:36 2019/3/19
 * @Modified By:
 */
public class OwnerInvocationHandler implements InvocationHandler {
    PersonBean person;

    public OwnerInvocationHandler(PersonBean person){
        this.person = person;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException{
        try {
            if (method.getName().startsWith("get")){
                return method.invoke(person, args);
            }else if (method.getName().equals("setHotOrNotRating")){
                throw new IllegalAccessException();
            }else if (method.getName().startsWith("set")){
                return method.invoke(person, args);
            }
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }
        return null;
    }
}
