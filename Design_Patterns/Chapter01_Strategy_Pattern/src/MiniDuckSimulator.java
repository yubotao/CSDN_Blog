import behavior.fly.FlyWithWings;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 17:54 2019/2/20
 * @Modified By:
 */
public class MiniDuckSimulator {
    public static void main(String[] args) {
        Duck model = new ModelDuck();
        model.performQuack();
        model.performFly();
        model.setFlyBehavior(new FlyWithWings());
        model.performFly();
    }
}
