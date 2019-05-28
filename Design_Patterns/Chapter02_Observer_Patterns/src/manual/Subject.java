package manual;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:41 2019/2/21
 * @Modified By:
 */
public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
