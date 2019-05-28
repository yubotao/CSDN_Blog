package yubotao.factory.store;

import yubotao.simple.Pizza;
import yubotao.factory.PizzaStore;
import yubotao.factory.pizza.NYStyleCheesePizza;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:05 2019/2/25
 * @Modified By:
 */
public class NYPizzaStore extends PizzaStore {
    public Pizza createPizza(String item){
        if (item.equals("cheese")){
            return new NYStyleCheesePizza();
//        }else if (item.equals("veggie")){
//            return new NYStyleVeggiePizza();
//        }else if (item.equals("clam")){
//            return new NYStyleClamPizza();
//        }else if (item.equals("pepperoni")){
//            return new NYStylePepperoniPizza();
        }else
            return null;
    }
}
