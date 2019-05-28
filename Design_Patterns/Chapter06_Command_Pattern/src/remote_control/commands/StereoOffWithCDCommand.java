package remote_control.commands;

import remote_control.receivers.Stereo;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:53 2019/3/4
 * @Modified By:
 */
public class StereoOffWithCDCommand implements Command {
    Stereo stereo;

    public StereoOffWithCDCommand(Stereo stereo){
        this.stereo = stereo;
    }

    public void execute(){
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(11);
    }
}
