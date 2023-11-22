
import java.util.Scanner;

public class CommandFactory {
    private TeamManager teamManager;
    private Scanner sc;

    public CommandFactory(TeamManager teamManager, Scanner sc) {
        this.teamManager = teamManager;
        this.sc = sc;
    }

    public Command createCommand(String commandType) {
        try {
            switch (commandType) {
                case "c":
                    return new CreateTeamCommand(sc, teamManager);
                case "g":
                    return new SetCurrentTeamCommand(sc, teamManager);
                case "a":
                    return new AddPlayerCommand(sc, teamManager);
                case "m":
                    return new ModifyPlayerPositionCommand(sc, teamManager);
                case "s":
                    return new DisplayCurrentTeamCommand(teamManager);
                case "d":
                    return new DeletePlayerCommand(sc, teamManager);
                case "p":
                    return new DisplayAllTeamCommand(teamManager);
                case "t":
                    return new ChangeCurrentTeamNameCommand(sc, teamManager, teamManager.getCurrentTeam());
                case "u":
                    return new UndoCommand(teamManager);
                case "r":
                    return new RedoCommand(teamManager);
                case "l":
                    return new ListUndoRedoCommand(teamManager);
                case "x":
                    return new ExitCommand();
                default:
                    return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
