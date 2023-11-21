import java.util.Scanner;

public class CreateTeamCommand implements Command {
    private Scanner sc;
    private TeamManager teamManager;
    private String teamID, Type, teamName;

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

        // 使用TeamFactory创建一个足球队
        Team newTeam = TeamFactory.createTeam(teamID, Type);
        newTeam.setName(teamName);
        teamManager.addTeam(newTeam);

        teamManager.setCurrentTeam(teamID);
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

}
