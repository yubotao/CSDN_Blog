package array_compare;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:41 2019/3/6
 * @Modified By:
 */
public class Duck implements Comparable{
    String name;
    int weight;

    public Duck(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    public String toString(){
        return name + " weights " + weight;
    }

    public int compareTo(Object o){
        Duck otherDuck = (Duck)o;

        if (this.weight < otherDuck.weight){
            return -1;
        }else if (this.weight == otherDuck.weight){
            return 0;
        }else {
            return 1;
        }
    }
}
