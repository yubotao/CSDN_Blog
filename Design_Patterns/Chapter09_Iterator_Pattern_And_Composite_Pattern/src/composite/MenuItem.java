package composite;

import java.util.Iterator;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 11:22 2019/3/12
 * @Modified By:
 */
public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price){
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    public void print(){
        System.out.print(" " + getName());
        if (isVegetarian()){
            System.out.print("(v)");
        }
        System.out.println("," + getPrice());
        System.out.println("     -- " + getDescription());
    }

    public Iterator createIterator(){
        return new NullIterator();
    }
}
