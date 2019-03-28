package iterator.manual;

import java.util.ArrayList;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:15 2019/3/12
 * @Modified By:
 */
public class PancakeIterator implements Iterator {
    ArrayList menuItems;
    int position = 0;

    public PancakeIterator(ArrayList menuItems){
        this.menuItems = menuItems;
    }

    public Object next(){
        MenuItem menuItem =(MenuItem) menuItems.get(position);
        position += 1;
        return menuItem;
    }

    @Override
    public boolean hasNext() {
        if (position >= menuItems.size()){
            return false;
        }else {
            return true;
        }
    }
}
