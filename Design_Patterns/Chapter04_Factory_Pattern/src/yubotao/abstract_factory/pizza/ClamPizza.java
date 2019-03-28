package yubotao.abstract_factory.pizza;

import yubotao.abstract_factory.Pizza;
import yubotao.abstract_factory.PizzaIngredientFactory;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:43 2019/2/25
 * @Modified By:
 */
public class ClamPizza extends Pizza {
    PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory ingredientFactory){
        this.ingredientFactory = ingredientFactory;
    }

    public void prepare(){
        System.out.println("Preparing " + name);
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
        cheese = ingredientFactory.createCheese();
        clams = ingredientFactory.createClams();
    }
}
