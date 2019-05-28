package dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:41 2019/3/19
 * @Modified By:
 */
public class NotOwnerInvocationHandler implements InvocationHandler {
    PersonBean person;

    public NotOwnerInvocationHandler(PersonBean person){
        this.person = person;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws IllegalAccessException{
        try {
            if (method.getName().startsWith("get")){
                return method.invoke(person, args);
            }else if (method.getName().equals("setHotOrNotRating")){
                return method.invoke(person, args);
            }else if (method.getName().startsWith("set")){
                throw new IllegalAccessException();

            }
        }catch (InvocationTargetException e){
            e.printStackTrace();
        }
        return null;
    }
}
