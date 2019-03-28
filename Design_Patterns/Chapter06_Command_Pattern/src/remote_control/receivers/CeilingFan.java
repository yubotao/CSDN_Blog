package remote_control.receivers;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:37 2019/3/4
 * @Modified By:
 */
public class CeilingFan {
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;
    String location;
    int speed;

    public CeilingFan(String location){
        this.location = location;
        speed = OFF;
    }

    public void high(){
        speed = HIGH;
        print();
    }

    public void medium(){
        speed = MEDIUM;
        print();
    }

    public void low(){
        speed = LOW;
        print();
    }

    public void on(){
        speed = HIGH;
        System.out.println(location + " ceiling fan is high");
    }

    public void off(){
        speed = OFF;
        System.out.println(location + " ceiling fan is off");
    }

    public int getSpeed() {
        return speed;
    }

    public void print(){
        System.out.println(location + " ceiling fan is " + getSpeed());
    }

}
