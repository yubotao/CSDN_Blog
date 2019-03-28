package remote_control.commands;

import remote_control.receivers.CeilingFan;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:56 2019/3/4
 * @Modified By:
 */
public class CeilingFanOffCommand implements Command {
    CeilingFan ceilingFan;

    public CeilingFanOffCommand(CeilingFan ceilingFan){
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.off();
    }

    @Override
    public void undo() {
        ceilingFan.on();
    }
}
