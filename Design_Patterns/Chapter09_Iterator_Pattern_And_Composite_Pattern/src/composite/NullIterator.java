package composite;

import java.util.Iterator;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 14:50 2019/3/12
 * @Modified By:
 */
public class NullIterator implements Iterator {
    public Object next(){
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
