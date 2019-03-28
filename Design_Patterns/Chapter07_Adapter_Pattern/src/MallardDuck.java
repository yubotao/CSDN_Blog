/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 14:36 2019/3/5
 * @Modified By:
 */
public class MallardDuck implements Duck {
    @Override
    public void quack() {
        System.out.println("Quack");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
