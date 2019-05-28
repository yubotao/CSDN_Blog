package concurrent.improvement;

/**
 * @Auther: yubt
 * @Description: 延迟初始化占位类，当任何线程第一次调用getResource时，都会使ResourceHolder被加载和被初始化，此时静态初始化器将执行Resource的初始化操作。
 *                 不需要同步。在急切初始化上改进得来。
 * @Date: Created in 11:27 2019/3/4
 * @Modified By:
 */
public class Singleton_Four {
    private static class ResourceHolder{
        public static Resource resource = new Resource();
    }

    public static Resource getResource(){
        return ResourceHolder.resource;
    }
}
