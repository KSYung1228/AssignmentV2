public class DisplayCurrentTeamCommand implements Command, Memento {
    private TeamManager teamManager;

    public DisplayCurrentTeamCommand(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    @Override
    public void execute() {
        Team currentTeam = teamManager.getCurrentTeam();
        if (currentTeam != null) {
            currentTeam.displayTeam();
        }
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

    @Override
    public String getDescription() {
        return null;
    }

}
