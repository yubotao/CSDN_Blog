package concurrent;

/**
 * @Auther: yubt
 * @Description: 在加载该类时，立即进行初始化，这样可以保证不使用同步；缺点是，可能初始化后并不会立即使用，造成资源的浪费（内存等）
 * @Date: Created in 11:19 2019/3/4
 * @Modified By:
 */
public class Singleton_Two {
    private static Singleton_Two uniqueInstance = new Singleton_Two();

    private Singleton_Two(){}

    public static Singleton_Two getInstance(){
        return uniqueInstance;
    }
}
