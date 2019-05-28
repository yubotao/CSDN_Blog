/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 11:14 2019/3/4
 * @Modified By:
 */
public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton(){}

    public static Singleton getInstance(){
        if (uniqueInstance == null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
