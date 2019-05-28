package yubotao.factory;

import yubotao.simple.Pizza;
import yubotao.factory.store.ChicagoPizzaStore;
import yubotao.factory.store.NYPizzaStore;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:16 2019/2/25
 * @Modified By:
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        Pizza pizza = nyStore.orderPizza("cheese");
        System.out.println("Ethan ordered a " + pizza.getName() + "\n");

        pizza = chicagoStore.orderPizza("cheese");
        System.out.println("Joel ordered a " + pizza.getName() + "\n");
    }
}
