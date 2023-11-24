
/**
 * command to create new team
 */
import java.util.Scanner;

public class CreateTeamCommand implements Command, Memento {
    private Scanner sc;
    private TeamManager teamManager;
    private String teamID, Type, teamName;
    private Team newTeam;

    // set system attribute
    public CreateTeamCommand(Scanner sc, TeamManager teamManager) {
        this.sc = sc;
        this.teamManager = teamManager;
    }

    // action to create team and preset current team
    @Override
    public void execute() {
        try {
            System.out.print("Enter sport type (v = volleyball | f = football) :-");
            Type = sc.nextLine();

            System.out.print("Enter team ID :-");
            teamID = sc.nextLine();

            System.out.print("Enter team name :-");
            teamName = sc.nextLine();

            newTeam = TeamFactory.createTeam(teamID, Type);
            newTeam.setName(teamName);
            teamManager.addTeam(newTeam);

            teamManager.setCurrentTeam(teamID);
            teamManager.pushCommand(this);
            Team currentTeam = teamManager.getCurrentTeam();
            System.out.println(currentTeam.getClass().getName() + " team is created.");
            System.out.println("Current team is changed to " + currentTeam.getTeamID());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // action to remove the created team, and set the current team to null
    @Override
    public void undo() {
        teamManager.removeTeam(newTeam);
        teamManager.setCurrentTeam(null);
    }

    // re-create team
    @Override
    public void redo() {
        teamManager.addTeam(newTeam);
        teamManager.setCurrentTeam(teamID);
    }

    // return the action description to caretaker
    @Override
    public String getDescription() {
        return "Create " + newTeam.getClass() + " team, " + teamID + ", " + teamName;
    }

}