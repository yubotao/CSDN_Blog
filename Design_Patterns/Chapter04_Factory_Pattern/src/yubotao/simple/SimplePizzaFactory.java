package yubotao.simple;

import yubotao.simple.pizza.CheesePizza;
import yubotao.simple.pizza.ClamPizza;
import yubotao.simple.pizza.PepperoniPizza;
import yubotao.simple.pizza.VeggiePizza;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:47 2019/2/25
 * @Modified By:
 */
public class SimplePizzaFactory {
    public Pizza createPizza(String type){
        Pizza pizza = null;

        if (type.equals("cheese")){
            pizza = new CheesePizza();
        }else if (type.equals("pepperoni")){
            pizza = new PepperoniPizza();
        }else if (type.equals("clam")){
            pizza = new ClamPizza();
        }else if (type.equals("veggie")){
            pizza = new VeggiePizza();
        }

        return pizza;
    }
}
