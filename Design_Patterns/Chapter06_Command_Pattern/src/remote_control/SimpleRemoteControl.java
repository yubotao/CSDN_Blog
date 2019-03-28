package remote_control;

import remote_control.commands.Command;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:56 2019/3/4
 * @Modified By:
 */
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl(){}

    public void setCommand(Command command){
        slot = command;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}
