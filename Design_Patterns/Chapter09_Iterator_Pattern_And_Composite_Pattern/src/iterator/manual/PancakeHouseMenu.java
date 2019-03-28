package iterator.manual;

import java.util.ArrayList;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:21 2019/3/12
 * @Modified By:
 */
public class PancakeHouseMenu {
    ArrayList menuItems;

    public PancakeHouseMenu(){
        menuItems = new ArrayList();

        addItem("K&B's Pancake Breakfast", "Pancakes with scrambled eggs, and toast", true,2.99);
        addItem("Regular Pancake Breakfast", "Pancakes with fried eggs, sausage", false, 2.99);
        addItem("Blueberry Pancakes", "Pancakes made with fresh blueberries", true, 3.49);
        addItem("Waffles", "Waffles, with your choice of blueberries or strawberries", true, 3.59);
    }

    public void addItem(String name, String description, boolean vegetarian, double price){
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuItems.add(menuItem);
    }

    public Iterator createIterator(){
        return new PancakeIterator(menuItems);
    }
}
