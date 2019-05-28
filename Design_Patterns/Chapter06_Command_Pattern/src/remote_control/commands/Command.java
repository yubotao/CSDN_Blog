package remote_control.commands;

/**
 * @Auther: yubt
 * @Description:
 * @Date: Created in 15:54 2019/3/4
 * @Modified By:
 */
public interface Command {
    public void execute();
    public void undo();
}
