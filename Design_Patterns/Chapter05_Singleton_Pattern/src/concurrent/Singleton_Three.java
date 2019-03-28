package concurrent;

/**
 * @Auther: yubt
 * @Description: 双重检查加锁，只在第一次时使用同步，并且实现了什么时候使用，什么时候加载；缺点是目前已经不推荐这种做法了，因为这种做法还是有自身缺陷，复杂且难以理解，不建议使用
 * @Date: Created in 11:23 2019/3/4
 * @Modified By:
 */
public class Singleton_Three {
    private volatile static Singleton_Three uniqueInstance;

    private Singleton_Three(){}

    public static Singleton_Three getInstance(){
        if (uniqueInstance == null){
            synchronized (Singleton_Three.class){
                if (uniqueInstance == null){
                    uniqueInstance = new Singleton_Three();
                }
            }
        }
        return uniqueInstance;
    }
}
