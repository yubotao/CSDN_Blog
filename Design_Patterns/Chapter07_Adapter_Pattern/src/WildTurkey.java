/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 14:37 2019/3/5
 * @Modified By:
 */
public class WildTurkey implements Turkey {
    @Override
    public void gobble() {
        System.out.println("Gobble gobble");
    }

    @Override
    public void fly() {
        System.out.println("I'm flying a short distance");
    }
}
