package remote_control.commands;

import remote_control.receivers.Light;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:55 2019/3/4
 * @Modified By:
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
