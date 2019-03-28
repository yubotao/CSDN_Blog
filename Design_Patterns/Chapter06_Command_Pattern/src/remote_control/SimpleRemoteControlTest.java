package remote_control;

import remote_control.commands.LightOnCommand;
import remote_control.receivers.Light;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:58 2019/3/4
 * @Modified By:
 */
public class SimpleRemoteControlTest {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light light = new Light("living room");
        LightOnCommand lightOn = new LightOnCommand(light);

        remote.setCommand(lightOn);
        remote.buttonWasPressed();
    }
}
