package starbuzz.condiment;

import starbuzz.Beverage;
import starbuzz.CondimentDecorator;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:41 2019/2/22
 * @Modified By:
 */
public class Whip extends CondimentDecorator {
    Beverage beverage;

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription(){
        return beverage.getDescription() + ", Whip";
    }

    @Override
    public double cost() {
        return .10 + beverage.cost();
    }
}
