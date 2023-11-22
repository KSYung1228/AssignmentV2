import java.util.Scanner;

public class CreateTeamCommand implements Command, Memento {
    private Scanner sc;
    private TeamManager teamManager;
    private String teamID, Type, teamName;
    private Team newTeam;

    public CreateTeamCommand(Scanner sc, TeamManager teamManager) {
        this.sc = sc;
        this.teamManager = teamManager;
    }

    @Override
    public void execute() {

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
    }

    @Override
    public void undo() {
        teamManager.removeTeam(newTeam);
    }

    @Override
    public void redo() {
        teamManager.addTeam(newTeam);
        teamManager.setCurrentTeam(teamID);
    }

    @Override
    public String getDescription() {
        return "Create " + Type + " team, " + teamID + ", " + teamName;
    }

}