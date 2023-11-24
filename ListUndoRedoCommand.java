/*
 * command to show the undo redo list
 */
public class ListUndoRedoCommand implements Command {
    private TeamManager teamManager;

    // set basic attribure
    public ListUndoRedoCommand(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    // dont need to return description
    @Override
    public String getDescription() {
        return null;
    }

    // action to show list
    @Override
    public void execute() {
        teamManager.showUndoList();
        teamManager.showRedoList();
    }

}
