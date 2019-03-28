package remote_control.commands;

import remote_control.receivers.GarageDoor;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:57 2019/3/4
 * @Modified By:
 */
public class GarageDoorDownCommand implements Command{
    GarageDoor garageDoor;

    public GarageDoorDownCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.down();
    }

    @Override
    public void undo() {
        garageDoor.up();
    }
}
