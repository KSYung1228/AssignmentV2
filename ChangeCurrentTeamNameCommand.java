
/*
 * this class is the commant to change the current team name
 */
import java.util.Scanner;

public class ChangeCurrentTeamNameCommand implements Command, Memento {
    private TeamManager teamManager;
    private Scanner sc;
    private String oldTeamName;
    private String newTeamName;
    private Team team;

    // set the basic attribute from system
    public ChangeCurrentTeamNameCommand(Scanner sc, TeamManager teamManager, Team team) {
        this.sc = sc;
        this.teamManager = teamManager;
        this.team = team;
    }

    // action to change the current team name, push the stack to caretaker
    @Override
    public void execute() {
        try {
            System.out.print("Please input new name of the current team:-");
            oldTeamName = teamManager.getCurrentTeam().getName();
            newTeamName = sc.nextLine();
            teamManager.changeCurrentTeamName(newTeamName);
            teamManager.pushCommand(this);
            System.out.println("Team's name is updated.");
        } catch (Exception e) {
            e.getMessage();
        }
    }

    // set back the old name for team
    @Override
    public void undo() {
        System.out.println("Undoing: changing team name from " + newTeamName + " to " + oldTeamName);
        teamManager.changeCurrentTeamName(oldTeamName);
    }

    // set the new name back to team
    @Override
    public void redo() {
        System.out.println("Redoing: changing team name from " + oldTeamName + " to " + newTeamName);
        teamManager.changeCurrentTeamName(newTeamName);
    }

    // return the action for caretaker
    @Override
    public String getDescription() {
        return "Change team's name, " + team.getTeamID() + " , " + newTeamName;
    }

}
