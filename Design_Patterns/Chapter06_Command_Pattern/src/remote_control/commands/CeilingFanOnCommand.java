package remote_control.commands;

import remote_control.receivers.CeilingFan;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:55 2019/3/4
 * @Modified By:
 */
public class CeilingFanOnCommand implements Command {
    CeilingFan ceilingFan;

    public CeilingFanOnCommand(CeilingFan ceilingFan){
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        ceilingFan.on();
    }

    @Override
    public void undo() {
        ceilingFan.off();
    }
}
