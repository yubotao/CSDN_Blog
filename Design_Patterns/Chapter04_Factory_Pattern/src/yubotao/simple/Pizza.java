package yubotao.simple;

import java.util.ArrayList;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:46 2019/2/25
 * @Modified By:
 */
public abstract class Pizza {
    public String name;
    public String dough;
    public String sauce;
    public ArrayList toppings = new ArrayList();

    public void prepare(){
        System.out.println("Preparing " + name);
        System.out.println("Tossing dough...");
        System.out.println("Adding sauce...");
        for (int i = 0; i < toppings.size(); i++){
            System.out.println("  " + toppings.get(i));
        }
    }

    public void bake(){
        System.out.println("Bake for 25 minutes at 350");
    }

    public void cut(){
        System.out.println("Cutting the pizza into diagonal slices");
    }

    public void box(){
        System.out.println("Place pizza in official PizzaStore box");
    }

    public String getName(){
        return name;
    }
}
