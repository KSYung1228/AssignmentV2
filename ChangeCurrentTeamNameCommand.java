import java.util.Scanner;

public class ChangeCurrentTeamNameCommand implements Command, Memento {
    private TeamManager teamManager;
    private Scanner sc;
    private String oldTeamName;
    private String newTeamName;

    public ChangeCurrentTeamNameCommand(Scanner sc, TeamManager teamManager) {
        this.sc = sc;
        this.teamManager = teamManager;
    }

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

    @Override
    public void undo() {
        System.out.println("Undoing: changing team name from " + newTeamName + " to " + oldTeamName);
        teamManager.changeCurrentTeamName(oldTeamName);
    }

    @Override
    public void redo() {
        System.out.println("Redoing: changing team name from " + oldTeamName + " to " + newTeamName);
        teamManager.changeCurrentTeamName(newTeamName);
    }

    @Override
    public String getDescription() {
        return "Change team's name, " + oldTeamName + " to " + newTeamName;
    }

}
