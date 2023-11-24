/*
 * Exit system
 */
public class ExitCommand implements Command {

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void execute() {
        System.exit(0);
    }

}
