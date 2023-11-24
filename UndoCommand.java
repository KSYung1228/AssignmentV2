//undo command for call caretaker undo action
public class UndoCommand implements Command, Memento {
    private TeamManager teamManager;

    // set basic attribute
    public UndoCommand(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    // dont need to return description
    @Override
    public String getDescription() {
        return null;
    }

    // action to call undo command
    @Override
    public void execute() {
        teamManager.undo();
    }

    // dont need to use undo,redo in undo action
    @Override
    public void undo() {
    }

    @Override
    public void redo() {

    }

}
