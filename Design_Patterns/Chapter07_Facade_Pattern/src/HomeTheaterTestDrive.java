import subsystem.*;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:58 2019/3/5
 * @Modified By:
 */
public class HomeTheaterTestDrive {
    public static void main(String[] args) {
        Amplifier amp = new Amplifier();
        Tuner tuner = new Tuner();
        DvdPlayer dvd = new DvdPlayer();
        CdPlayer cd = new CdPlayer();
        Projector projector = new Projector();
        Screen screen = new Screen();
        TheaterLights lights = new TheaterLights();
        PopcornPopper popper = new PopcornPopper();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd, cd, projector, lights, screen, popper);

        homeTheater.watchMovie("Raiders of the Lost Ark");
        System.out.println("\n-----------Watching Movies------------\n");
        homeTheater.endMovie();
    }
}
