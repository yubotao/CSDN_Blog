package remote_control.receivers;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:37 2019/3/4
 * @Modified By:
 */
public class Stereo {
    String location;

    public Stereo(String location){
        this.location = location;
    }

    public void on(){
        System.out.println(location + " stereo is on");
    }

    public void setCD(){
        System.out.println(location + " stereo is set for CD input");
    }

    public void setVolume(int volume){
        System.out.println(location + " stereo volume set to " + volume);
    }

    public void off(){
        System.out.println(location + " stereo is off");
    }
}
