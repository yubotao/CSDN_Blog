package yubotao.abstract_factory;

import yubotao.abstract_factory.ingredient.cheese.Cheese;
import yubotao.abstract_factory.ingredient.clam.Clams;
import yubotao.abstract_factory.ingredient.dough.Dough;
import yubotao.abstract_factory.ingredient.pepperoni.Pepperoni;
import yubotao.abstract_factory.ingredient.sauce.Sauce;
import yubotao.abstract_factory.ingredient.veggies.Veggies;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:23 2019/2/25
 * @Modified By:
 */
public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggies[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClams();
}
