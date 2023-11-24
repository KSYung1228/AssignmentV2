/*
 * Command to Display the team
 */
public class DisplayAllTeamCommand implements Command, Memento {
    private TeamManager teamManager;

    // set the attribute from system
    public DisplayAllTeamCommand(TeamManager teamManager) {
        this.teamManager = teamManager;
    }

    // action to display all team
    @Override
    public void execute() {
        teamManager.displayAllTeams();
    }

    // dont need to undo and redo, and no description return
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
