package composite;

import java.util.Iterator;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 11:30 2019/3/12
 * @Modified By:
 */
public class Waitress {
    MenuComponent allMenus;

    public Waitress(MenuComponent allMenus){
        this.allMenus = allMenus;
    }

    public void printMenu(){
        allMenus.print();
    }

    public void printVegetarianMenu(){
        Iterator iterator = allMenus.createIterator();
        System.out.println("\nVEGETARIAN MENU\n-----");
        while (iterator.hasNext()){
            MenuComponent menuComponent = (MenuComponent)iterator.next();
            try {
                if (menuComponent.isVegetarian()){
                    menuComponent.print();
                }
            }catch (UnsupportedOperationException e){}
        }
    }
}
