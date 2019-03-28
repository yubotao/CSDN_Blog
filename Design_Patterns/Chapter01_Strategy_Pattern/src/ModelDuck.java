import behavior.fly.FlyNoWay;
import behavior.quack.Quack;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 17:52 2019/2/20
 * @Modified By:
 */
public class ModelDuck extends Duck{
    public ModelDuck(){
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("I'm a model duck");
    }
}
