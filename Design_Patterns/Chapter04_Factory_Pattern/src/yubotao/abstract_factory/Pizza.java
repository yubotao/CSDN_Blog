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
 * @Date: Created in 15:46 2019/2/25
 * @Modified By:
 */
public abstract class Pizza {
    public String name;
    public Dough dough;
    public Sauce sauce;
    public Veggies veggies[];
    public Cheese cheese;
    public Pepperoni pepperoni;
    public Clams clams;

    public abstract void prepare();

    public void bake(){
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut(){
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box(){
        System.out.println("Place pizza in official PizzaStore box");
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
