package mvc;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:05 2019/3/28
 * @Modified By:
 */
public interface BeatModelInterface {
    void initialize();
    void on();
    void off();
    void setBPM(int bpm);
    int getBPM();
    void registerObserver(BeatObserver o);
    void removeObserver(BeatObserver o);
    void registerObserver(BPMObserver o);
    void removeObserver(BPMObserver o);
}
