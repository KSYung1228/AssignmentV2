public class ListUndoRedoCommand implements Command {
    private TeamManager teamManager;

    public ListUndoRedoCommand(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void execute() {
        teamManager.showHistoryUndoList();
        teamManager.showHistoryRedoList();
    }

}
