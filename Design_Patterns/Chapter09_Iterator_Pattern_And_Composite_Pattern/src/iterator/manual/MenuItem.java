package iterator.manual;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 9:55 2019/3/12
 * @Modified By:
 */
public class MenuItem {
    public String name;
    public String description;
    public boolean vegetarian;
    public double price;

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

    public double getPrice() {
        return price;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }
}
