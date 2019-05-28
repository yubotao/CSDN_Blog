package remote_control.commands;

import remote_control.receivers.GarageDoor;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:56 2019/3/4
 * @Modified By:
 */
public class GarageDoorUpCommand implements Command{
    GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor garageDoor){
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }

    @Override
    public void undo() {
        garageDoor.down();
    }
}
