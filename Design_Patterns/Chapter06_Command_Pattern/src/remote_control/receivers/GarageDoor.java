package remote_control.receivers;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:37 2019/3/4
 * @Modified By:
 */
public class GarageDoor {
    String location;

    public GarageDoor(String location){
        this.location = location;
    }

    public void up(){
        System.out.println(location + " Garage Door is Open");
    }

    public void down(){
        System.out.println(location + " Garage Door is Close");
    }
}
