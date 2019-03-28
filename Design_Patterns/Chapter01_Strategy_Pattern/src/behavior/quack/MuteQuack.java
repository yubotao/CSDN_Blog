package behavior.quack;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 17:50 2019/2/20
 * @Modified By:
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
