package yubotao.factory.pizza;

import yubotao.simple.Pizza;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:11 2019/2/25
 * @Modified By:
 */
public class NYStyleCheesePizza extends Pizza {
    public NYStyleCheesePizza(){
        name = "NY Style Sauce and Cheese Pizza";
        dough = "Thin Crust Dough";
        sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }
}
