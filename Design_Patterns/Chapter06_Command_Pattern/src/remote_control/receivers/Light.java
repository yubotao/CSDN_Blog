package remote_control.receivers;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:00 2019/3/4
 * @Modified By:
 */
public class Light {
    String location;

    public Light(String location){
        this.location = location;
    }

    public void on(){
        System.out.println(location + " light is on");
    }

    public void off(){
        System.out.println(location + " light is off");
    }
}
