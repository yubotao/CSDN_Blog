package yubotao.factory.store;

import yubotao.simple.Pizza;
import yubotao.factory.PizzaStore;
import yubotao.factory.pizza.ChicagoStyleCheesePizza;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:20 2019/2/25
 * @Modified By:
 */
public class ChicagoPizzaStore extends PizzaStore {
    public Pizza createPizza(String item){
        if (item.equals("cheese")){
            return new ChicagoStyleCheesePizza();
//        }else if (item.equals("veggie")){
//            return new ChicagoStyleVeggiePizza();
//        }else if (item.equals("clam")){
//            return new ChicagoStyleClamPizza();
//        }else if (item.equals("pepperoni")){
//            return new ChicagoStylePepperoniPizza();
        }else
            return null;
    }
}
