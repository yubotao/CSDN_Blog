package subsystem;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 14:54 2019/3/5
 * @Modified By:
 */
public class TheaterLights {
    public void dim(int brightness){
        System.out.println("Theater Ceiling Lights dimming to " + brightness + "%");
    }

    public void on(){
        System.out.println("Theater Ceiling Lights on");
    }
}
