
import java.util.*;

public class SetCurrentTeamCommand implements Command, Memento {
    private TeamManager teamManager;
    private Scanner sc;
    private String teamID;
    private String oldTeamID;

    public SetCurrentTeamCommand(Scanner sc, TeamManager teamManager) {
        this.sc = sc;
        this.teamManager = teamManager;
    }

    @Override
    public void execute() {
        System.out.print("Please input team ID:-");
        teamID = sc.nextLine();

        // Save the old team ID
        oldTeamID = teamManager.getCurrentTeam().getTeamID();

        teamManager.setCurrentTeam(teamID);
        teamManager.pushCommand(this);
        System.out.println("Chnaged current team to " + teamID);
    }

    @Override
    public void undo() {
        if (oldTeamID != null) {
            teamManager.setCurrentTeam(oldTeamID);
        }
    }

    @Override
    public void redo() {
        teamManager.setCurrentTeam(teamID);
    }

    @Override
    public String getDescription() {
        return "Set current team, Team ID: " + teamID;
    }
}