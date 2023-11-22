public class DisplayAllTeamCommand implements Command, Memento {
    private TeamManager teamManager;

    public DisplayAllTeamCommand(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    @Override
    public void execute() {
        teamManager.displayAllTeams();
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
