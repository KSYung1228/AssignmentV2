
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

        if (teamManager.teamExists(teamID)) {
            teamManager.setCurrentTeam(teamID);
            // teamManager.pushCommand(this);
            System.out.println("Changed current team to " + teamID);
        } else {
            System.out.println(teamID + " is not found!!");
        }
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