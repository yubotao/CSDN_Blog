package yubotao.abstract_factory;


/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:03 2019/2/25
 * @Modified By:
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type){
        Pizza pizza;

        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    public abstract Pizza createPizza(String type);
}
