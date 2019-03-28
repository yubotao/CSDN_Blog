package behavior.fly;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 17:49 2019/2/20
 * @Modified By:
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly");
    }
}
