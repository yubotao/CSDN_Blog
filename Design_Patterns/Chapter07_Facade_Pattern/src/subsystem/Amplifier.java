package subsystem;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 14:53 2019/3/5
 * @Modified By:
 */
public class Amplifier {
    public void on(){
        System.out.println("Top-O-Line Amplifier on");
    }

    public void setDvd(){
        System.out.println("Top-O-Line Amplifier setting DVD player to Top-O-Line DVD Player");
    }

    public void setSurroundSound(){
        System.out.println("Top-O-Line Amplifier surround sound on (5 speakers, 1 subwoofer)");
    }

    public void setVolume(int volume){
        System.out.println("Top-O-Line Amplifier setting volume");
    }

    public void off(){
        System.out.println("Top-O-Line Amplifier off");
    }
}
