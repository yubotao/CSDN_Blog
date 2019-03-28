package behavior.quack;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 17:49 2019/2/20
 * @Modified By:
 */
public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
