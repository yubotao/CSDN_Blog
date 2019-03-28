package yubotao.abstract_factory.ingredientFactory;

import yubotao.abstract_factory.PizzaIngredientFactory;
import yubotao.abstract_factory.ingredient.cheese.Cheese;
import yubotao.abstract_factory.ingredient.cheese.MozzarellaCheese;
import yubotao.abstract_factory.ingredient.clam.Clams;
import yubotao.abstract_factory.ingredient.clam.FrozenClams;
import yubotao.abstract_factory.ingredient.dough.Dough;
import yubotao.abstract_factory.ingredient.dough.ThickCrustDough;
import yubotao.abstract_factory.ingredient.pepperoni.Pepperoni;
import yubotao.abstract_factory.ingredient.pepperoni.SlicedPepperoni;
import yubotao.abstract_factory.ingredient.sauce.PlumTomatoSauce;
import yubotao.abstract_factory.ingredient.sauce.Sauce;
import yubotao.abstract_factory.ingredient.veggies.Garlic;
import yubotao.abstract_factory.ingredient.veggies.Mushroom;
import yubotao.abstract_factory.ingredient.veggies.Onion;
import yubotao.abstract_factory.ingredient.veggies.Veggies;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:53 2019/2/25
 * @Modified By:
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Veggies[] createVeggies() {
        Veggies veggies[] = {new Garlic(), new Onion(), new Mushroom()};
        return veggies;
    }

    @Override
    public Pepperoni createPepperoni() {
        return new SlicedPepperoni();
    }

    @Override
    public Clams createClams() {
        return new FrozenClams();
    }
}
