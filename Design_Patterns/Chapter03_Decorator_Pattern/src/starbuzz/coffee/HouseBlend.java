package starbuzz.coffee;

import starbuzz.Beverage;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:38 2019/2/22
 * @Modified By:
 */
public class HouseBlend extends Beverage {
    public HouseBlend(){
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return .89;
    }
}
