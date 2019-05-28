package starbuzz.condiment;

import starbuzz.Beverage;
import starbuzz.CondimentDecorator;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:39 2019/2/22
 * @Modified By:
 */
public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription(){
        return beverage.getDescription() + ", Mocha";
    }

    @Override
    public double cost() {
        return .20 + beverage.cost();
    }
}
