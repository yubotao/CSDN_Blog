package composite;


import java.util.Iterator;
import java.util.Stack;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 14:41 2019/3/12
 * @Modified By:
 */
public class CompositeIterator implements Iterator {
    Stack stack = new Stack();

    public CompositeIterator(Iterator iterator){
        stack.push(iterator);
    }

    public Object next(){
        if (hasNext()){
            // 注意这里取的是栈的最上层迭代器，所以如果一个迭代器下还有迭代器的时候，优先取下层迭代器的值，然后再回到上层。
            // 这才是递归的关键所在。
            Iterator iterator = (Iterator) stack.peek();
            MenuComponent component = (MenuComponent) iterator.next();
            if (component instanceof Menu){
                stack.push(component.createIterator());
            }
            return component;
        }else {
            return null;
        }
    }

    @Override
    public boolean hasNext() {
        if (stack.isEmpty()){
            return false;
        }else {
            Iterator iterator = (Iterator) stack.peek();
            if (!iterator.hasNext()){
                stack.pop();
                return hasNext();
            }else {
                return true;
            }
        }
    }

    public void remove(){
        throw new UnsupportedOperationException();
    }
}
