
/*
 * Command to set the current team
 */
import java.util.*;

public class SetCurrentTeamCommand implements Command, Memento {
    private TeamManager teamManager;
    private Scanner sc;
    private String teamID;
    private String oldTeamID;

    // set the basic attribute
    public SetCurrentTeamCommand(Scanner sc, TeamManager teamManager) {
        this.sc = sc;
        this.teamManager = teamManager;
    }

    // action to set the current team by using team manager
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

    // set the currentteam back if before have current team
    @Override
    public void undo() {
        if (oldTeamID != null) {
            teamManager.setCurrentTeam(oldTeamID);
        }
    }

    // re-set the current team back
    @Override
    public void redo() {
        teamManager.setCurrentTeam(teamID);
    }

    // return the description back
    @Override
    public String getDescription() {
        return "Set current team, Team ID: " + teamID;
    }
}