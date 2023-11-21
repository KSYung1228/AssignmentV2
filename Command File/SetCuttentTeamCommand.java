import java.util.*;

public class SetCuttentTeamCommand implements Command {
    private TeamManager teamManager;
    private Scanner sc;
    private String teamID;

    public SetCuttentTeamCommand(Scanner sc, TeamManager teamManager) {
        this.sc = sc;
        this.teamManager = teamManager;
    }

    @Override
    public void execute() {
        System.out.print("Please input team ID:-");
        teamID = sc.nextLine();
        teamManager.setCurrentTeam(teamID);
    }

    @Override
    public void undo() {

    }

    @Override
    public void redo() {

    }

}
