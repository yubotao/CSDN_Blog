package yubotao.abstract_factory.ingredientFactory;

import yubotao.abstract_factory.PizzaIngredientFactory;
import yubotao.abstract_factory.ingredient.cheese.Cheese;
import yubotao.abstract_factory.ingredient.cheese.ReggianoCheese;
import yubotao.abstract_factory.ingredient.clam.Clams;
import yubotao.abstract_factory.ingredient.clam.FreshClams;
import yubotao.abstract_factory.ingredient.dough.Dough;
import yubotao.abstract_factory.ingredient.dough.ThinCrustDough;
import yubotao.abstract_factory.ingredient.pepperoni.Pepperoni;
import yubotao.abstract_factory.ingredient.pepperoni.SlicedPepperoni;
import yubotao.abstract_factory.ingredient.sauce.MarinaraSauce;
import yubotao.abstract_factory.ingredient.sauce.Sauce;
import yubotao.abstract_factory.ingredient.veggies.Garlic;
import yubotao.abstract_factory.ingredient.veggies.Mushroom;
import yubotao.abstract_factory.ingredient.veggies.Onion;
import yubotao.abstract_factory.ingredient.veggies.Veggies;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:35 2019/2/25
 * @Modified By:
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
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
        return new FreshClams();
    }
}
