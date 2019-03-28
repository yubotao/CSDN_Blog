package remote_control.commands;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 17:16 2019/3/4
 * @Modified By:
 */
public class MacroCommand implements Command {
    Command[] commands;

    public MacroCommand(Command[] commands){
        this.commands = commands;
    }

    @Override
    public void execute() {
        for (int i = 0; i < commands.length; i++){
            commands[i].execute();
        }
    }

    @Override
    public void undo() {
        for (int i = 0; i < commands.length; i++){
            commands[i].undo();
        }
    }
}
