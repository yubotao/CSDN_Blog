package dynamic_proxy;

import java.lang.reflect.Proxy;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:42 2019/3/19
 * @Modified By:
 */
public class MatchMakingTestDrive {

    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }

    public MatchMakingTestDrive(){
    }

    public void drive(){
        PersonBean joe = getPersonFromDatabase("Joe JavaBean");
        PersonBean ownerProxy = getOwnerProxy(joe);
        System.out.println("Name is " + ownerProxy.getName());
        ownerProxy.setInterests("bowling, Go");
        System.out.println("Interests set from owner proxy");
        try {
            ownerProxy.setHotOrNotRating(10);
        }catch (Exception e){
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getHotOrNotRating());

        System.out.println("\n------------\n");

        PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("Name is " + nonOwnerProxy.getName());
        try {
            nonOwnerProxy.setInterests("what the fuck!");
        }catch (Exception e){
            System.out.println("Can't set interests from non owner proxy");
        }
        nonOwnerProxy.setHotOrNotRating(3);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
    }

    PersonBean getOwnerProxy(PersonBean person){
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person)
        );
    }

    PersonBean getNonOwnerProxy(PersonBean person){
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NotOwnerInvocationHandler(person)
        );
    }

    PersonBean getPersonFromDatabase(String name){
        PersonBean person = new PersonBeanImpl();
        person.setName(name);
        person.setHotOrNotRating(7);

        return person;
    }

}
