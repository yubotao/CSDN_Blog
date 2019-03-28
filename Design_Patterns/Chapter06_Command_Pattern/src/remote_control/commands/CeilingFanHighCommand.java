package remote_control.commands;

import remote_control.receivers.CeilingFan;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 17:12 2019/3/4
 * @Modified By:
 */
public class CeilingFanHighCommand implements Command {
    CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan){
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    @Override
    public void undo() {
        if (prevSpeed == CeilingFan.HIGH){
            ceilingFan.high();
        }else if (prevSpeed == CeilingFan.MEDIUM){
            ceilingFan.medium();
        }else if (prevSpeed == CeilingFan.LOW){
            ceilingFan.low();
        }else if (prevSpeed == CeilingFan.OFF){
            ceilingFan.off();
        }
    }
}
