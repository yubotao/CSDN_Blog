package starbuzz.coffee;

import starbuzz.Beverage;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:37 2019/2/22
 * @Modified By:
 */
public class Espresso extends Beverage {
    public Espresso(){
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
