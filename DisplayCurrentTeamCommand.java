/*
 * Command to display detail for current team
 */
public class DisplayCurrentTeamCommand implements Command, Memento {
    private TeamManager teamManager;

    public DisplayCurrentTeamCommand(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    // action to display current team
    @Override
    public void execute() {
        Team currentTeam = teamManager.getCurrentTeam();
        if (currentTeam != null) {
            currentTeam.displayTeam();
        }
    }

    // dont need to do undo redo, no description return
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
