package mvc;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 10:04 2019/3/28
 * @Modified By:
 */
public class DJTestDrive {
    public static void main(String[] args) {
        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);
    }
}
