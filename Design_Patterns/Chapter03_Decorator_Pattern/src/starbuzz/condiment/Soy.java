package starbuzz.condiment;

import starbuzz.Beverage;
import starbuzz.CondimentDecorator;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:42 2019/2/22
 * @Modified By:
 */
public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage){
        this.beverage = beverage;
    }

    public String getDescription(){
        return beverage.getDescription() + ", Soy";
    }

    @Override
    public double cost() {
        return .15 + beverage.cost();
    }
}
