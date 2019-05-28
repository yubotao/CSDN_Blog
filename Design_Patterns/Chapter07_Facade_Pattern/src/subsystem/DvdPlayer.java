package subsystem;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 14:54 2019/3/5
 * @Modified By:
 */
public class DvdPlayer {
    String movie;

    public void on(){
        System.out.println("Top-O-Line Dvd Player on");
    }

    public void play(String movie){
        this.movie = movie;
        System.out.println("Top-O-Line Dvd Player playing \"" + movie + "\"");
    }

    public void stop(){
        System.out.println("Top-O-Line Dvd Player stopped \"" + movie + "\"");
    }

    public void eject(){
        System.out.println("Top-O-Line Dvd Player eject");
    }

    public void off(){
        System.out.println("Top-O-Line Dvd Player off");
    }
}
