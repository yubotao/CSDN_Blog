package concurrent;

/**
 * @Auther: yubt
 * @Description: 同步getInstance方法，避免多线程中出现多个单例实现；缺点是每次都需要同步，造成性能下降
 * @Date: Created in 11:17 2019/3/4
 * @Modified By:
 */
public class Singleton_One {
    private static Singleton_One uniqueInstance;

    private Singleton_One(){}

    private static synchronized Singleton_One getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Singleton_One();
        }
        return uniqueInstance;
    }
}
