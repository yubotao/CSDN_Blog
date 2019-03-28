package iterator.manual;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:01 2019/3/12
 * @Modified By:
 */
public class DinerMenuIterator implements Iterator {
    MenuItem[] items;
    int position = 0;

    public DinerMenuIterator(MenuItem[] items){
        this.items = items;
    }

    public Object next(){
        MenuItem menuItem = items[position];
        position += 1;
        return menuItem;
    }

    @Override
    public boolean hasNext() {
        if (position >= items.length || items[position] == null) {
            return false;
        }else {
            return true;
        }
    }
}
