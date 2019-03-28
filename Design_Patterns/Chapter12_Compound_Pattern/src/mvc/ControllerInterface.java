package mvc;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 11:10 2019/3/28
 * @Modified By:
 */
public interface ControllerInterface {
    void start();
    void stop();
    void increaseBPM();
    void decreaseBPM();
    void setBPM(int bpm);
}
