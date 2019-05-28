package remote_control.commands;

import remote_control.receivers.Light;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 16:21 2019/3/4
 * @Modified By:
 */
public class LightOffCommand implements Command {
    Light light;

    public LightOffCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
