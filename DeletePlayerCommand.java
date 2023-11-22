import java.util.Scanner;

public class DeletePlayerCommand implements Command, Memento {
    private Scanner sc;
    private TeamManager teamManager;
    private String playerId;
    private Player deletedPlayer;

    public DeletePlayerCommand(Scanner sc, TeamManager teamManager) {
        this.sc = sc;
        this.teamManager = teamManager;
    }

    @Override
    public void execute() {
        try {
            System.out.print("Please input player ID:-");
            playerId = sc.nextLine();

            // Save the player before deleting
            deletedPlayer = teamManager.getPlayer(playerId);

            if (deletedPlayer != null) {
                teamManager.deletePlayer(playerId);
            }
            teamManager.pushCommand(this);
            System.out.println("Player is deleted.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void undo() {
        if (deletedPlayer != null) {
            teamManager.addPlayer(deletedPlayer, teamManager.getCurrentTeam().getTeamID());
        }
    }

    @Override
    public void redo() {
        if (deletedPlayer != null) {
            teamManager.deletePlayer(playerId);
        }
    }

    @Override
    public String getDescription() {
        return "Delete player, ID: " + playerId;
    }

}