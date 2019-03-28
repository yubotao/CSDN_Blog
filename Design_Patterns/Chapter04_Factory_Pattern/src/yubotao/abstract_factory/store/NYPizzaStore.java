package yubotao.abstract_factory.store;

import yubotao.abstract_factory.Pizza;
import yubotao.abstract_factory.PizzaIngredientFactory;
import yubotao.abstract_factory.PizzaStore;
import yubotao.abstract_factory.ingredientFactory.NYPizzaIngredientFactory;
import yubotao.abstract_factory.pizza.CheesePizza;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:05 2019/2/25
 * @Modified By:
 */
public class NYPizzaStore extends PizzaStore {
    public Pizza createPizza(String item){
        Pizza pizza = null;
        PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
        if (item.equals("cheese")){
            pizza = new CheesePizza(ingredientFactory);
            pizza.setName("New York Style Cheese Pizza");
        }// 省略其他类型pizza

        return pizza;
    }
}
