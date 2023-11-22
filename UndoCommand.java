
public class UndoCommand implements Command, Memento {
    private TeamManager teamManager;

    public UndoCommand(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public void execute() {
        teamManager.undo();
    }

    @Override
    public void undo() {
    }

    @Override
    public void redo() {

    }

}
