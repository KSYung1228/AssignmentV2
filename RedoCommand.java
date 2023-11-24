/*
 * command to active the redo action for all command chich in stack
 */
public class RedoCommand implements Command {

    private TeamManager teamManager;

    public RedoCommand(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void execute() {
        teamManager.redo();
    }

}
