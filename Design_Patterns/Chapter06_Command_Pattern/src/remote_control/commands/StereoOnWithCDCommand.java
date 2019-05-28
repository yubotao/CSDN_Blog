package remote_control.commands;

import remote_control.receivers.Stereo;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:23 2019/3/4
 * @Modified By:
 */
public class StereoOnWithCDCommand implements Command {
    Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo){
        this.stereo = stereo;
    }

    public void execute(){
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
