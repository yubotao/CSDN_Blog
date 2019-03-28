package yubotao.factory.pizza;

import yubotao.simple.Pizza;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:13 2019/2/25
 * @Modified By:
 */
public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza(){
        name = "Chicago Style Deep Dish Cheese Pizza";
        dough = "Extra Thick Crust Dough";
        sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }

    public void cut(){
        System.out.println("Cutting the pizza into square slices");
    }
}
